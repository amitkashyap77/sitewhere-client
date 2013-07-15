/*
 * ZoneCreateRequest.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.request;

import java.util.ArrayList;
import java.util.List;

import com.sitewhere.rest.model.common.Location;
import com.sitewhere.rest.model.device.MetadataProvider;
import com.sitewhere.spi.common.ILocation;
import com.sitewhere.spi.device.request.IZoneCreateRequest;

/**
 * Provides parameters needed to create a new zone.
 * 
 * @author Derek
 */
public class ZoneCreateRequest extends MetadataProvider implements IZoneCreateRequest {

	/** Unique zone token */
	private String token;

	/** Zone name */
	private String name;

	/** Locations that define zone */
	private List<Location> coordinates = new ArrayList<Location>();

	/** Border color in UI */
	private String borderColor;

	/** Fill color in UI */
	private String fillColor;

	/** Opacity in UI */
	private Double opacity;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.request.IZoneCreateRequest#getToken()
	 */
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.request.IZoneCreateRequest#getName()
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.request.IZoneCreateRequest#getCoordinates()
	 */
	@SuppressWarnings("unchecked")
	public List<ILocation> getCoordinates() {
		return (List<ILocation>) (List<? extends ILocation>) coordinates;
	}

	public void setCoordinates(List<Location> coordinates) {
		this.coordinates = coordinates;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.request.IZoneCreateRequest#getBorderColor()
	 */
	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.request.IZoneCreateRequest#getFillColor()
	 */
	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.request.IZoneCreateRequest#getOpacity()
	 */
	public Double getOpacity() {
		return opacity;
	}

	public void setOpacity(Double opacity) {
		this.opacity = opacity;
	}
}