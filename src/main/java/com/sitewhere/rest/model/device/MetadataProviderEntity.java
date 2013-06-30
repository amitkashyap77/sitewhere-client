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

import java.util.Calendar;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sitewhere.rest.model.JsonCalendarSerializer;
import com.sitewhere.spi.device.IMetadataProviderEntity;

/**
 * Metadata provider that also contains SiteWhere entity information.
 * 
 * @author Derek Adams
 */
public class MetadataProviderEntity extends MetadataProvider implements IMetadataProviderEntity {

	/** Date entity was created */
	private Calendar createdDate;

	/** Username for creator */
	private String createdBy;

	/** Date entity was last updated */
	private Calendar updatedDate;

	/** Username that updated entity */
	private String updatedBy;

	/** Indicates if entity has been deleted */
	private boolean deleted;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.common.ISiteWhereEntity#getCreatedDate()
	 */
	@JsonSerialize(using = JsonCalendarSerializer.class)
	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.common.ISiteWhereEntity#getCreatedBy()
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.common.ISiteWhereEntity#getUpdatedDate()
	 */
	@JsonSerialize(using = JsonCalendarSerializer.class)
	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.common.ISiteWhereEntity#getUpdatedBy()
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.common.ISiteWhereEntity#isDeleted()
	 */
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * Copy fields from source to target.
	 * 
	 * @param source
	 * @param target
	 */
	public static void copy(IMetadataProviderEntity source, MetadataProviderEntity target) {
		target.setCreatedDate(source.getCreatedDate());
		target.setCreatedBy(source.getCreatedBy());
		target.setUpdatedDate(source.getUpdatedDate());
		target.setUpdatedBy(source.getUpdatedBy());
		target.setDeleted(source.isDeleted());
		MetadataProvider.copy(source, target);
	}
}