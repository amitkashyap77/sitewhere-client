/*
 * DeviceEventWithAsset.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.asset;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sitewhere.rest.model.datatype.JsonDateSerializer;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.asset.IAsset;
import com.sitewhere.spi.asset.IAssetModuleManager;
import com.sitewhere.spi.common.IMetadataEntry;
import com.sitewhere.spi.device.DeviceAssignmentType;
import com.sitewhere.spi.device.IDeviceEvent;
import com.sitewhere.spi.device.asset.IDeviceEventWithAsset;

/**
 * Wraps a device event and provides extra information the associated asset from its
 * assignment.
 * 
 * @author Derek
 */
public class DeviceEventWithAsset implements IDeviceEventWithAsset {

	/** Wrapped event */
	protected IDeviceEvent wrapped;

	/** Associated asset */
	protected IAsset asset;

	public DeviceEventWithAsset(IDeviceEvent wrapped, IAssetModuleManager assets) throws SiteWhereException {
		this.wrapped = wrapped;
		this.asset = assets.getAssignedAsset(wrapped.getAssignmentType(), wrapped.getAssetId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.asset.IDeviceEventWithAsset#getAssetName()
	 */
	@Override
	public String getAssetName() {
		if (asset != null) {
			return asset.getName();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.spi.common.IMetadataProvider#addOrReplaceMetadata(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void addOrReplaceMetadata(String name, String value) {
		getWrapped().addOrReplaceMetadata(name, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.common.IMetadataProvider#removeMetadata(java.lang.String)
	 */
	@Override
	public IMetadataEntry removeMetadata(String name) {
		return getWrapped().removeMetadata(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.common.IMetadataProvider#getMetadata(java.lang.String)
	 */
	@Override
	public IMetadataEntry getMetadata(String name) {
		return getWrapped().getMetadata(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.common.IMetadataProvider#getMetadata()
	 */
	@Override
	public List<IMetadataEntry> getMetadata() {
		return getWrapped().getMetadata();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(IDeviceEvent o) {
		return getWrapped().compareTo(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceEvent#getSiteToken()
	 */
	@Override
	public String getSiteToken() {
		return getWrapped().getSiteToken();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceEvent#getDeviceAssignmentToken()
	 */
	@Override
	public String getDeviceAssignmentToken() {
		return getWrapped().getDeviceAssignmentToken();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceEvent#getAssignmentType()
	 */
	@Override
	public DeviceAssignmentType getAssignmentType() {
		return getWrapped().getAssignmentType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceEvent#getAssetId()
	 */
	@Override
	public String getAssetId() {
		return getWrapped().getAssetId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceEvent#getEventDate()
	 */
	@Override
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getEventDate() {
		return getWrapped().getEventDate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.device.IDeviceEvent#getReceivedDate()
	 */
	@Override
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getReceivedDate() {
		return getWrapped().getReceivedDate();
	}

	protected IDeviceEvent getWrapped() {
		return wrapped;
	}
}