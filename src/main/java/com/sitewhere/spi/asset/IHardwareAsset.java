/*
* $Id$
* --------------------------------------------------------------------------------------
* Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
*
* The software in this package is published under the terms of the CPAL v1.0
* license, a copy of which has been included with this distribution in the
* LICENSE.txt file.
*/

package com.sitewhere.spi.asset;

/**
 * Interface for an asset that is a piece of hardware.
 * 
 * @author dadams
 */
public interface IHardwareAsset extends IAsset {

	/**
	 * Get the asset name.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Get the stock keeping unit (SKU).
	 * 
	 * @return
	 */
	public String getSku();

	/**
	 * Get the asset description.
	 * 
	 * @return
	 */
	public String getDescription();

	/**
	 * Get URL for asset image.
	 * 
	 * @return
	 */
	public String getImageUrl();

	/**
	 * Get property that holds asset name.
	 * 
	 * @return
	 */
	public String getNameProperty();

	/**
	 * Get property that holds SKU.
	 * 
	 * @return
	 */
	public String getSkuProperty();

	/**
	 * Get property that holds asset description.
	 * 
	 * @return
	 */
	public String getDescriptionProperty();

	/**
	 * Get property that holds image URL.
	 * 
	 * @return
	 */
	public String getImageUrlProperty();
}