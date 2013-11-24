/*
 * IDeviceModelInitializer.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.server.device;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.IDeviceManagement;

/**
 * Class that initializes the device model with data needed to bootstrap the system.
 * 
 * @author Derek
 */
public interface IDeviceModelInitializer {

	/**
	 * Initialize the device model.
	 * 
	 * @param deviceManagement
	 * @throws SiteWhereException
	 */
	public void initialize(IDeviceManagement deviceManagement) throws SiteWhereException;
}