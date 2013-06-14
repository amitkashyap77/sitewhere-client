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

import java.util.List;

/**
 * Holds interpolated locations for an assignment in one-minute intervals.
 * 
 * @author Derek Adams
 */
public class InterpolatedAssignmentHistory {

	/** Device assignment token */
	private String deviceAssignmentToken;

	/** Asset name */
	private String assetName;

	/** List of history entries */
	private List<DeviceAssignmentHistoryEntry> slots;

	public String getDeviceAssignmentToken() {
		return deviceAssignmentToken;
	}

	public void setDeviceAssignmentToken(String deviceAssignmentToken) {
		this.deviceAssignmentToken = deviceAssignmentToken;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public List<DeviceAssignmentHistoryEntry> getSlots() {
		return slots;
	}

	public void setSlots(List<DeviceAssignmentHistoryEntry> slots) {
		this.slots = slots;
	}
}