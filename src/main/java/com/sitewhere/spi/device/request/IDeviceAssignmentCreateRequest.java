/*
 * IDeviceAssignmentCreateRequest.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.request;

import com.sitewhere.spi.asset.AssetType;
import com.sitewhere.spi.common.IMetadataProvider;

/**
 * Interface for arguments needed to create a device assignment.
 * 
 * @author Derek
 */
public interface IDeviceAssignmentCreateRequest extends IMetadataProvider {

	/**
	 * Get the unique device hardware id.
	 * 
	 * @return
	 */
	public String getDeviceHardwareId();

	/**
	 * Get token of assigned site.
	 * 
	 * @return
	 */
	public String getSiteToken();

	/**
	 * Get assigned asset type.
	 * 
	 * @return
	 */
	public AssetType getAssetType();

	/**
	 * Get assigned asset id.
	 * 
	 * @return
	 */
	public String getAssetId();
}