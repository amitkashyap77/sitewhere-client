/*
 * IDeviceEventBatchResponse.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device;

import java.util.List;

import com.sitewhere.rest.model.device.DeviceEventBatch;

/**
 * Response generated when a {@link DeviceEventBatch} has been processed.
 * 
 * @author Derek
 */
public interface IDeviceEventBatchResponse {

	/**
	 * List of measurements that were created.
	 * 
	 * @return
	 */
	public List<IDeviceMeasurements> getCreatedMeasurements();

	/**
	 * List of locations that were created.
	 * 
	 * @return
	 */
	public List<IDeviceLocation> getCreatedLocations();

	/**
	 * List of alerts that were created.
	 * 
	 * @return
	 */
	public List<IDeviceAlert> getCreatedAlerts();
}