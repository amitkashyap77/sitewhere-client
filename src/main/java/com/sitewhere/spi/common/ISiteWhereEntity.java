/*
* $Id$
* --------------------------------------------------------------------------------------
* Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
*
* The software in this package is published under the terms of the CPAL v1.0
* license, a copy of which has been included with this distribution in the
* LICENSE.txt file.
*/

package com.sitewhere.spi.common;

import java.util.Calendar;

/**
 * Base interface for entites managed by SiteWhere.
 * 
 * @author Derek Adams
 */
public interface ISiteWhereEntity {

	/**
	 * Get date when entity was created.
	 * 
	 * @return
	 */
	public Calendar getCreatedDate();

	/**
	 * Get username that created entity.
	 * 
	 * @return
	 */
	public String getCreatedBy();

	/**
	 * Get date when entity was last updated.
	 * 
	 * @return
	 */
	public Calendar getUpdatedDate();

	/**
	 * Get username that last updated entity.
	 * 
	 * @return
	 */
	public String getUpdatedBy();

	/**
	 * Indicates if entity has been deleted.
	 * 
	 * @return
	 */
	public boolean isDeleted();
}