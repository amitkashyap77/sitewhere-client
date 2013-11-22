/*
 * DeviceLocationWithAsset.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.asset;

import com.sitewhere.rest.model.device.DeviceLocation;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.asset.IAssetModuleManager;
import com.sitewhere.spi.device.IDeviceLocation;

/**
 * Wraps a {@link DeviceLocation} so that information about the asset associated with its
 * assignment is available.
 * 
 * @author Derek
 */
public class DeviceLocationWithAsset extends DeviceEventWithAsset implements IDeviceLocation {

	public DeviceLocationWithAsset(IDeviceLocation wrapped, IAssetModuleManager assets)
			throws SiteWhereException {
		super(wrapped, assets);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceLocation#getLatitude()
	 */
	@Override
	public Double getLatitude() {
		return ((IDeviceLocation) getWrapped()).getLatitude();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceLocation#getLongitude()
	 */
	@Override
	public Double getLongitude() {
		return ((IDeviceLocation) getWrapped()).getLongitude();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceLocation#getElevation()
	 */
	@Override
	public Double getElevation() {
		return ((IDeviceLocation) getWrapped()).getElevation();
	}
}