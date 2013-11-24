/*
 * IUserModelInitializer.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.server.user;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.user.IUserManagement;

/**
 * Class that initializes the user model with data needed to bootstrap the system.
 * 
 * @author Derek
 */
public interface IUserModelInitializer {

	/**
	 * Initialize the user model.
	 * 
	 * @param userManagement
	 * @throws SiteWhereException
	 */
	public void initialize(IUserManagement userManagement) throws SiteWhereException;
}