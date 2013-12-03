/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.sitewhere.rest.model.device;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sitewhere.rest.model.asset.HardwareAsset;
import com.sitewhere.rest.model.asset.PersonAsset;
import com.sitewhere.rest.model.common.MetadataProviderEntity;
import com.sitewhere.rest.model.datatype.JsonDateSerializer;
import com.sitewhere.spi.device.DeviceAssignmentStatus;
import com.sitewhere.spi.device.DeviceAssignmentType;
import com.sitewhere.spi.device.IDeviceAssignment;

/**
 * Device assignment value object used for marshaling.
 * 
 * @author dadams
 */
@JsonInclude(Include.NON_NULL)
public class DeviceAssignment extends MetadataProviderEntity implements IDeviceAssignment {

	/** Unique assignment token */
	private String token;

	/** Device being assigned */
	private Device device;

	/** Device hardware id */
	private String deviceHardwareId;

	/** Type of associated asset */
	private DeviceAssignmentType assignmentType;

	/** Id of associated asset */
	private String assetId;

	/** Associated asset name */
	private String assetName;

	/** Associated asset image */
	private String assetImageUrl;

	/** Assigned site */
	private Site site;

	/** Site token */
	private String siteToken;

	/** Assignment status */
	private DeviceAssignmentStatus status;

	/** Assignment start date */
	private Date activeDate;

	/** Assignment end date */
	private Date releasedDate;

	/** Last known location */
	private DeviceAssignmentState state;

	/** Associated person asset */
	private PersonAsset associatedPerson;

	/** Associated hardware asset */
	private HardwareAsset associatedHardware;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceAssignment#getToken()
	 */
	@Override
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceAssignment#getDeviceHardwareId()
	 */
	@Override
	public String getDeviceHardwareId() {
		return deviceHardwareId;
	}

	public void setDeviceHardwareId(String deviceHardwareId) {
		this.deviceHardwareId = deviceHardwareId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceAssignment#getAssignmentType()
	 */
	@Override
	public DeviceAssignmentType getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(DeviceAssignmentType assignmentType) {
		this.assignmentType = assignmentType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceAssignment#getAssetId()
	 */
	@Override
	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetImageUrl() {
		return assetImageUrl;
	}

	public void setAssetImageUrl(String assetImageUrl) {
		this.assetImageUrl = assetImageUrl;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceAssignment#getSiteToken()
	 */
	@Override
	public String getSiteToken() {
		return siteToken;
	}

	public void setSiteToken(String siteToken) {
		this.siteToken = siteToken;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceAssignment#getStatus()
	 */
	@Override
	public DeviceAssignmentStatus getStatus() {
		return status;
	}

	public void setStatus(DeviceAssignmentStatus status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceAssignment#getActiveDate()
	 */
	@JsonSerialize(using = JsonDateSerializer.class)
	@Override
	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceAssignment#getReleasedDate()
	 */
	@JsonSerialize(using = JsonDateSerializer.class)
	@Override
	public Date getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(Date releasedDate) {
		this.releasedDate = releasedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceAssignment#getState()
	 */
	@Override
	public DeviceAssignmentState getState() {
		return state;
	}

	public void setState(DeviceAssignmentState state) {
		this.state = state;
	}

	public PersonAsset getAssociatedPerson() {
		return associatedPerson;
	}

	public void setAssociatedPerson(PersonAsset associatedPerson) {
		this.associatedPerson = associatedPerson;
	}

	public HardwareAsset getAssociatedHardware() {
		return associatedHardware;
	}

	public void setAssociatedHardware(HardwareAsset associatedHardware) {
		this.associatedHardware = associatedHardware;
	}
}