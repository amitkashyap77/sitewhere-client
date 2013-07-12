/*
 * IDeviceAlertCreateRequest.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.request;

/**
 * Interface for arguments needed to create a device alert.
 * 
 * @author Derek
 */
public interface IDeviceAlertCreateRequest extends IDeviceEventCreateRequest {

	/**
	 * Get the alert type indicator.
	 * 
	 * @return
	 */
	public String getType();

	/**
	 * Get the alert message.
	 * 
	 * @return
	 */
	public String getMessage();
}