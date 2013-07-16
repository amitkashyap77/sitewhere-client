/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.sitewhere.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.sitewhere.rest.model.common.Location;
import com.sitewhere.rest.model.device.Device;
import com.sitewhere.rest.model.device.DeviceAssignment;
import com.sitewhere.rest.model.device.DeviceMeasurements;
import com.sitewhere.rest.model.device.Zone;
import com.sitewhere.rest.model.device.request.DeviceAssignmentCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceMeasurementsCreateRequest;
import com.sitewhere.rest.service.SiteWhereClient;
import com.sitewhere.rest.service.search.ZoneSearchResults;
import com.sitewhere.spi.ISiteWhereClient;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.SiteWhereSystemException;
import com.sitewhere.spi.asset.AssetType;
import com.sitewhere.spi.error.ErrorCode;

/**
 * Test cases for client API calls.
 * 
 * @author dadams
 */
public class ApiTests {

	/** Hardware id used for test cases */
	public static final String TEST_HARDWARE_ID = "12356789-TEST-123";

	/** Asset id for testing */
	public static final String TEST_ASSET_ID = "174";

	/** Site token used in tests */
	public static final String TEST_SITE_TOKEN = "22223793-3028-4114-86ba-aefc7d05369f";

	/** SiteWhere client */
	private ISiteWhereClient client;

	@Before
	public void setup() {
		this.client = new SiteWhereClient();
	}

	@Test
	public void testDeviceCRUD() throws SiteWhereException {
		// Delete device if it already exists.
		try {
			client.getDeviceByHardwareId(TEST_HARDWARE_ID);
			client.deleteDevice(TEST_HARDWARE_ID, true);
		} catch (SiteWhereException e) {
			// Ignore missing device since we wanted it deleted.
		}

		// Test initial create.
		DeviceCreateRequest request = new DeviceCreateRequest();
		request.setHardwareId(TEST_HARDWARE_ID);
		request.setAssetId(TEST_ASSET_ID);
		request.setComments("This is a test device.");
		request.addOrReplaceMetadata("name1", "value1");
		request.addOrReplaceMetadata("name2", "value2");
		Device device = client.createDevice(request);
		Assert.assertNotNull("Device create returned null.", device);
		Assert.assertEquals("Metadata not stored properly.", 2, device.getMetadata().size());

		// Test get by hardware id.
		try {
			device = client.getDeviceByHardwareId(TEST_HARDWARE_ID);
		} catch (SiteWhereException e) {
			Assert.fail("Device should exist, but not found by handware id.");
		}

		// Test update.
		DeviceCreateRequest update = new DeviceCreateRequest();
		update.setComments("Updated.");
		update.addOrReplaceMetadata("name1", "value1");
		device = client.updateDevice(TEST_HARDWARE_ID, update);
		Assert.assertEquals("Updated.", device.getComments());
		Assert.assertEquals("Metadata not updated properly.", 1, device.getMetadata().size());
		Assert.assertNotNull("Updated date not set.", device.getUpdatedDate());

		// Should not allow hardware id to be updated.
		try {
			update = new DeviceCreateRequest();
			update.setHardwareId("xxx");
			client.updateDevice(TEST_HARDWARE_ID, update);
			Assert.fail("Device update allowed update of hardware id.");
		} catch (SiteWhereSystemException e) {
			verifyErrorCode(e, ErrorCode.DeviceHardwareIdCanNotBeChanged);
		}

		// Test duplicate.
		try {
			device = client.createDevice(request);
			Assert.fail("Create device allowed duplicate.");
		} catch (SiteWhereException e) {
			verifyErrorCode(e, ErrorCode.DuplicateHardwareId);
		}

		// Create a device assignment.
		DeviceAssignmentCreateRequest assnRequest = new DeviceAssignmentCreateRequest();
		assnRequest.setSiteToken(TEST_SITE_TOKEN);
		assnRequest.setAssetType(AssetType.Hardware);
		assnRequest.setAssetId(TEST_ASSET_ID);
		assnRequest.setDeviceHardwareId(device.getHardwareId());
		assnRequest.addOrReplaceMetadata("name1", "value1");
		assnRequest.addOrReplaceMetadata("name2", "value2");
		assnRequest.addOrReplaceMetadata("name1", "value2");
		DeviceAssignment assignment = client.createDeviceAssignment(assnRequest);
		Assert.assertNotNull("Assignment token was null.", assignment.getToken());
		Assert.assertEquals("Assignment metadata count incorrect.", 2, assignment.getMetadata().size());

		// Test getting current assignment for a device.
		DeviceAssignment currAssignment = client.getCurrentAssignmentForDevice(TEST_HARDWARE_ID);
		Assert.assertEquals("Current device assignment is incorrect.", assignment.getToken(),
				currAssignment.getToken());

		// Verify that an assignment can not be created for a device if one is already assigned.
		try {
			assignment = client.createDeviceAssignment(assnRequest);
		} catch (SiteWhereException e) {
			verifyErrorCode(e, ErrorCode.DeviceAlreadyAssigned);
		}

		// Delete device.
//		device = client.deleteDevice(TEST_HARDWARE_ID, true);
//		Assert.assertNotNull(device);
	}

	@Test
	public void testCreateMeasurements() throws SiteWhereException {
		SiteWhereClient client = new SiteWhereClient();
		String assignmentToken = "7139bbf5-f65d-42d7-9783-5d8603526f0d";
		DeviceMeasurementsCreateRequest measurements = new DeviceMeasurementsCreateRequest();
		measurements.setEventDate(new Date());
		measurements.addOrReplaceMeasurement("test", "123");
		measurements.addOrReplaceMeasurement("another", "another");
		DeviceMeasurements results = client.createDeviceMeasurements(assignmentToken, measurements);
		System.out.println("Created " + results.getMeasurements().size() + " measurements.");
	}

	@Test
	public void testCreateZone() throws SiteWhereException {
		SiteWhereClient client = new SiteWhereClient();
		Zone zone = new Zone();
		zone.setName("My Test Zone");
		zone.setSiteToken("b2229cb1-de4e-4114-9863-08d0efd81064");
		List<Location> coords = new ArrayList<Location>();
		coords.add(new Location(30.0, -85.0));
		coords.add(new Location(30.0, -90.0));
		coords.add(new Location(35.0, -90.0));
		coords.add(new Location(35.0, -85.0));
		zone.setCoordinates(coords);
		Zone results = client.createZone(zone);
		System.out.println("Created zone: " + results.getName());
		ZoneSearchResults search = client.listZonesForSite("b2229cb1-de4e-4114-9863-08d0efd81064");
		System.out.println("Found " + search.getNumResults() + " results.");
	}

	/**
	 * Verifies that
	 * 
	 * @param e
	 */
	protected void verifyErrorCode(SiteWhereException e, ErrorCode code) {
		if (e instanceof SiteWhereSystemException) {
			SiteWhereSystemException sw = (SiteWhereSystemException) e;
			if (code != sw.getCode()) {
				Assert.fail("Unexpected error code returned. Expected " + code.getCode() + " but got: "
						+ sw.getCode());
			}
		} else {
			Assert.fail("Unexpected exception: " + e.getMessage());
		}
	}
}