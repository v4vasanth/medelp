package com.medelp.backend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * 
 * @author vasanth
 *
 */
@Entity
public class Driver {

	@Id private String driverId; 
	
	private String email;

	private String phoneNumber;
	
	private String deviceId;
	
	private String address;
	
	private boolean isCheckedIn;

	public String getEmail() {
	    return email;
	}

	public String getDriverId() {
		return driverId;
	}

	public String getPhoneNumber() {
	    return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}

	public String getDeviceId() {
	    return deviceId;
	}

	public void setDeviceId(String deviceId) {
	    this.deviceId = deviceId;
	}
	
	public String getAddress() {
	    return address;
	}

	public void setAddress(String address) {
	    this.address = address;
	}
	
	public boolean isCheckedIn() {
	    return isCheckedIn;
	}

	public void setCheckedIn(boolean isCheckedIn) {
	    this.isCheckedIn = isCheckedIn;
	}
}
