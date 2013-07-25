/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.sitewhere.spi.device;

import java.util.Date;

import com.sitewhere.spi.asset.AssetType;

/**
 * Assigns a device to a physical entity being monitored. A device may be used for multiple assets over a
 * period of time.
 * 
 * @author Derek
 */
public interface IDeviceAssignment extends IMetadataProviderEntity {

	/**
	 * Get token that uniquely identifies the assignment.
	 * 
	 * @return
	 */
	public String getToken();

	/**
	 * Get hardware id for assigned device.
	 * 
	 * @return
	 */
	public String getDeviceHardwareId();

	/**
	 * Get token for assigned site.
	 * 
	 * @return
	 */
	public String getSiteToken();

	/**
	 * Get the referenced asset type.
	 * 
	 * @return
	 */
	public AssetType getAssetType();

	/**
	 * Get the asset identifier.
	 * 
	 * @return
	 */
	public String getAssetId();

	/**
	 * Get the device assignement status.
	 * 
	 * @return
	 */
	public DeviceAssignmentStatus getStatus();

	/**
	 * Get the date/time at which the assignment was made active.
	 * 
	 * @return
	 */
	public Date getActiveDate();

	/**
	 * Get the date/time at which the assignment was released.
	 * 
	 * @return
	 */
	public Date getReleasedDate();

	/**
	 * Get the last known location of the assignment.
	 * 
	 * @return
	 */
	public IDeviceLocation getLastLocation();
}