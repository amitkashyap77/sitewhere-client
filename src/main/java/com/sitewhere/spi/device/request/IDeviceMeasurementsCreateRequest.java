/*
 * IDeviceMeasurementsCreateRequest.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.request;

import com.sitewhere.spi.device.IMetadataProvider;

/**
 * Interface for arguments needed to create device measurements.
 * 
 * @author Derek
 */
public interface IDeviceMeasurementsCreateRequest extends IDeviceEventCreateRequest {

	/**
	 * Get metadata provider for measurements.
	 * 
	 * @return
	 */
	public IMetadataProvider getMeasurementsMetadata();
}