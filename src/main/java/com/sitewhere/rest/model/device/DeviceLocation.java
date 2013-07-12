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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.device.IDeviceLocation;

/**
 * Represents the location of a device at a moment in time.
 * 
 * @author dadams
 */
@JsonInclude(Include.NON_NULL)
public class DeviceLocation extends DeviceEvent implements IDeviceLocation {

	/** Latitude value */
	private Double latitude;

	/** Longitude value */
	private Double longitude;

	/** Elevation value */
	private Double elevation;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceLocation#getLatitude()
	 */
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceLocation#getLongitude()
	 */
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceLocation#getElevation()
	 */
	public Double getElevation() {
		return elevation;
	}

	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}

	/**
	 * Create a copy of an SPI object. Used by web services for marshaling.
	 * 
	 * @param input
	 * @return
	 */
	public static DeviceLocation copy(IDeviceLocation input) {
		DeviceLocation result = new DeviceLocation();
		DeviceEvent.copy(input, result);
		result.setLatitude(input.getLatitude());
		result.setLongitude(input.getLongitude());
		result.setElevation(input.getElevation());
		return result;
	}
}