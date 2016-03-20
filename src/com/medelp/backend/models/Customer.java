package com.medelp.backend.models;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * 
 * @author vasanth
 *
 */
@Entity
public class Customer {

	@Id
	private String customerId;

	private String email;

	private String phoneNumber;

	private String deviceId;

	private String address;

	public Customer(String userId, String email, String phoneNumber, String deviceId, String address) {
		this.customerId = userId;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.deviceId = deviceId;
	}

	private Customer() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCustomerId() {
		return customerId;
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

	public void updateDetails(String newPhoneNumber, String newAddress, String newDeviceId) {
		if (newPhoneNumber != null)
			this.phoneNumber = newPhoneNumber;
		if (newAddress != null)
			this.address = newAddress;
		if (newDeviceId != null)
			this.deviceId = newDeviceId;
	}

	public String getWebsafeKey() {
		return Key.create(Customer.class, customerId).getString();
	}
}
