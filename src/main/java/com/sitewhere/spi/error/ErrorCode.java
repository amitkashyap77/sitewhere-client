/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.sitewhere.spi.error;

/**
 * Enumerates various system error conditions and gives them unique codes.
 * 
 * @author Derek
 */
public enum ErrorCode {

	/*********
	 * USERS *
	 *********/

	/** Bad username */
	InvalidUsername(100, "Username does not exist."),

	/** Bad password */
	InvalidPassword(101, "Password did not match."),

	/** Username already used */
	DuplicateUser(102, "Username already in use."),

	/** Invalid authority reference */
	InvalidAuthority(120, "Authority does not exist"),

	/** Authority name already used */
	DuplicateAuthority(121, "Authority name already in use."),

	/***************************
	 * INVALID OR DUPLICATE ID *
	 ***************************/

	/** Attempting to create a device with a duplicate hardware id */
	DuplicateHardwareId(500, "The given hardware id is already in use."),

	/** Invalid device hardware id */
	InvalidHardwareId(501, "Hardware id not found."),

	/** Invalid asset reference id */
	InvalidAssetReferenceId(502, "Asset reference not found."),

	/** Invalid site token */
	InvalidSiteToken(504, "Site not found."),

	/** Invalid manufacturer id */
	InvalidDeviceManufacturerId(505, "Device manufacturer not found."),

	/** Invalid device model id */
	InvalidDeviceModelId(506, "Device model not found."),

	/** Invalid site assignment id */
	InvalidDeviceAssignmentId(520, "Device assignment not found."),

	/** Invalid device assignment token */
	InvalidDeviceAssignmentToken(521, "Device assignment token not found."),

	/** Invalid zone token */
	InvalidZoneToken(522, "Zone not found."),

	/** Invalid device location id */
	InvalidDeviceLocationId(523, "Device location not found for id."),

	/** Invalid device measurements id */
	InvalidDeviceMeasurementsId(524, "Device measurements not found for id."),

	/** Invalid device alert id */
	InvalidDeviceAlertId(525, "Device alert not found for id."),

	/**********
	 * DEVICE *
	 **********/

	/** Attempting to create a new assignment for a device with an active assignment */
	DeviceAlreadyAssigned(600, "Device already has an active assignment."),

	/** Operation assumes device is assigned but no assignment exists */
	DeviceNotAssigned(601, "Device is not currently assigned."),

	/** Operation assumes device is assigned but no assignment exists */
	DeviceHardwareIdCanNotBeChanged(602, "Device hardware id can not be updated."),

	/** Operation assumes device is assigned but no assignment exists */
	DeviceCanNotBeDeletedIfAssigned(603, "Device can not be deleted if it is currently assigned."),

	/********
	 * ZONE *
	 ********/

	/** Zone delete failure message */
	ZoneDeleteFailed(700, "Unable to delete zoned."),

	/***********
	 * GENERIC *
	 ***********/

	/** Generic delete failure message */
	GenericDeleteFailed(1000, "Delete unsuccessful."),

	/*********
	 * OTHER *
	 *********/

	/** Error with no explanation */
	Unknown(9999, "Unknown error.");

	/** Numeric code */
	private long code;

	/** Error message */
	private String message;

	private ErrorCode(long code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}

	/**
	 * Look up the enum based on error code.
	 * 
	 * @param code
	 * @return
	 */
	public static ErrorCode fromCode(long code) {
		for (ErrorCode current : ErrorCode.values()) {
			if (current.getCode() == code) {
				return current;
			}
		}
		throw new RuntimeException("Invalid error code: " + code);
	}

	public void setCode(long code) {
		this.code = code;
	}

	public long getCode() {
		return code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}