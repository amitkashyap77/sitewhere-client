/*
 * IDeviceAssignmentState.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device;

import java.util.List;

/**
 * Holds event state for a device assignment including most recent location, measurements
 * and alerts.
 * 
 * @author Derek
 */
public interface IDeviceAssignmentState {

	/**
	 * Get last device location.
	 * 
	 * @return
	 */
	public IDeviceLocation getLastLocation();

	/**
	 * Get last measurement for each measurement id.
	 * 
	 * @return
	 */
	public List<IDeviceMeasurement> getLatestMeasurements();

	/**
	 * Get last alert for each alert type.
	 * 
	 * @return
	 */
	public List<IDeviceAlert> getLatestAlerts();
}