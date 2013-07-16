/*
 * DeviceMeasurementsCreateRequest.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.device.DeviceMeasurements;
import com.sitewhere.rest.model.device.MetadataEntry;
import com.sitewhere.rest.model.device.MetadataProvider;
import com.sitewhere.spi.device.IMetadataEntry;
import com.sitewhere.spi.device.request.IDeviceMeasurementsCreateRequest;

/**
 * Model object used to create a new {@link DeviceMeasurements} via REST APIs.
 * 
 * @author Derek
 */
@JsonIgnoreProperties
@JsonInclude(Include.NON_NULL)
public class DeviceMeasurementsCreateRequest extends DeviceEventCreateRequest implements
		IDeviceMeasurementsCreateRequest {

	/** Measurements metadata */
	private MetadataProvider measurementsMetadata = new MetadataProvider();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IMeasurementsProvider#addOrReplaceMeasurement(java.lang.String,
	 * java.lang.String)
	 */
	public void addOrReplaceMeasurement(String name, String value) {
		measurementsMetadata.addOrReplaceMetadata(name, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IMeasurementsProvider#removeMeasurement(java.lang.String)
	 */
	public IMetadataEntry removeMeasurement(String name) {
		return measurementsMetadata.removeMetadata(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IMeasurementsProvider#getMeasurement(java.lang.String)
	 */
	public IMetadataEntry getMeasurement(String name) {
		return measurementsMetadata.getMetadata(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IMeasurementsProvider#getMeasurements()
	 */
	public List<IMetadataEntry> getMeasurements() {
		return measurementsMetadata.getMetadata();
	}

	/**
	 * Needed for JSON marshaling.
	 * 
	 * @param entries
	 */
	public void setMeasurements(List<MetadataEntry> entries) {
		this.measurementsMetadata = new MetadataProvider();
		for (MetadataEntry entry : entries) {
			measurementsMetadata.addOrReplaceMetadata(entry.getName(), entry.getValue());
		}
	}
}