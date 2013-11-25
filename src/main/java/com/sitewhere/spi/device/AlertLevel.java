/*
 * AlertLevel.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device;

/**
 * Indicates severity of alert.
 * 
 * @author Derek
 */
public enum AlertLevel {

	/** Informational alert */
	Info,

	/** Warning condition */
	Warning,

	/** Error condition */
	Error,

	/** Critical error */
	Critical;
}