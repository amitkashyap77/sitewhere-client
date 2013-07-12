/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.sitewhere.rest.model;

import java.util.ArrayList;
import java.util.List;

import com.sitewhere.spi.ISiteWhereContext;
import com.sitewhere.spi.device.IDevice;
import com.sitewhere.spi.device.IDeviceAlert;
import com.sitewhere.spi.device.IDeviceAssignment;
import com.sitewhere.spi.device.IDeviceLocation;
import com.sitewhere.spi.device.IDeviceMeasurements;
import com.sitewhere.spi.device.ISite;
import com.sitewhere.spi.device.request.IDeviceAlertCreateRequest;
import com.sitewhere.spi.device.request.IDeviceLocationCreateRequest;
import com.sitewhere.spi.device.request.IDeviceMeasurementsCreateRequest;

/**
 * Default context implementation.
 * 
 * @author dadams
 */
public class SiteWhereContext implements ISiteWhereContext {

	/** Site for current device assignment */
	private ISite site;

	/** Device associated with current request */
	private IDevice device;

	/** Current assignment for device */
	private IDeviceAssignment deviceAssignment;

	/** Measurements that have not been persisted */
	private List<IDeviceMeasurementsCreateRequest> unsavedDeviceMeasurements =
			new ArrayList<IDeviceMeasurementsCreateRequest>();

	/** Locations that have not been persisted */
	private List<IDeviceLocationCreateRequest> unsavedDeviceLocations =
			new ArrayList<IDeviceLocationCreateRequest>();

	/** Alerts that have not been persisted */
	private List<IDeviceAlertCreateRequest> unsavedDeviceAlerts =
			new ArrayList<IDeviceAlertCreateRequest>();

	/** Measurements that have been persisted */
	private List<IDeviceMeasurements> deviceMeasurements = new ArrayList<IDeviceMeasurements>();

	/** Locations that have been persisted */
	private List<IDeviceLocation> deviceLocations = new ArrayList<IDeviceLocation>();

	/** Alerts that have been persisted */
	private List<IDeviceAlert> deviceAlerts = new ArrayList<IDeviceAlert>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.ISiteWhereContext#getSite()
	 */
	public ISite getSite() {
		return site;
	}

	public void setSite(ISite site) {
		this.site = site;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.ISiteWhereContext#getDevice()
	 */
	public IDevice getDevice() {
		return device;
	}

	public void setDevice(IDevice device) {
		this.device = device;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.ISiteWhereContext#getDeviceAssignment()
	 */
	public IDeviceAssignment getDeviceAssignment() {
		return deviceAssignment;
	}

	public void setDeviceAssignment(IDeviceAssignment deviceAssignment) {
		this.deviceAssignment = deviceAssignment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.ISiteWhereContext#getUnsavedDeviceMeasurements()
	 */
	public List<IDeviceMeasurementsCreateRequest> getUnsavedDeviceMeasurements() {
		return unsavedDeviceMeasurements;
	}

	public void setUnsavedDeviceMeasurements(
			List<IDeviceMeasurementsCreateRequest> unsavedDeviceMeasurements) {
		this.unsavedDeviceMeasurements = unsavedDeviceMeasurements;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.ISiteWhereContext#getUnsavedDeviceLocations()
	 */
	public List<IDeviceLocationCreateRequest> getUnsavedDeviceLocations() {
		return unsavedDeviceLocations;
	}

	public void setUnsavedDeviceLocations(List<IDeviceLocationCreateRequest> unsavedDeviceLocations) {
		this.unsavedDeviceLocations = unsavedDeviceLocations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.ISiteWhereContext#getUnsavedDeviceAlerts()
	 */
	public List<IDeviceAlertCreateRequest> getUnsavedDeviceAlerts() {
		return unsavedDeviceAlerts;
	}

	public void setUnsavedDeviceAlerts(List<IDeviceAlertCreateRequest> unsavedDeviceAlerts) {
		this.unsavedDeviceAlerts = unsavedDeviceAlerts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.ISiteWhereContext#getDeviceMeasurements()
	 */
	public List<IDeviceMeasurements> getDeviceMeasurements() {
		return deviceMeasurements;
	}

	public void setDeviceMeasurements(List<IDeviceMeasurements> deviceMeasurements) {
		this.deviceMeasurements = deviceMeasurements;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.ISiteWhereContext#getDeviceLocations()
	 */
	public List<IDeviceLocation> getDeviceLocations() {
		return deviceLocations;
	}

	public void setDeviceLocations(List<IDeviceLocation> deviceLocations) {
		this.deviceLocations = deviceLocations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.ISiteWhereContext#getDeviceAlerts()
	 */
	public List<IDeviceAlert> getDeviceAlerts() {
		return deviceAlerts;
	}

	public void setDeviceAlerts(List<IDeviceAlert> deviceAlerts) {
		this.deviceAlerts = deviceAlerts;
	}
}