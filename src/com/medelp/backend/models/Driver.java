package com.medelp.backend.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * 
 * @author vasanth
 *
 */
@Entity
public class Driver {

	@Id private String driverId; 
	
	private String email;

	@Index
	private String phoneNumber;
	
	private String deviceId;
	
	private String address;
	
	@Index
	private boolean isCheckedIn;
	
	private Driver() {}
	
	public Driver(String driverId, String email, String phoneNumber, String deviceId, String addess) {
		this.driverId = driverId;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = addess;
	}

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
	
	public void updateDetails(String newPhoneNumber, String newAddress, String newDeviceId) {
		if (newPhoneNumber != null)
			this.phoneNumber = newPhoneNumber;
		if (newAddress != null)
			this.address = newAddress;
		if (newDeviceId != null)
			this.deviceId = newDeviceId;
	}
}
