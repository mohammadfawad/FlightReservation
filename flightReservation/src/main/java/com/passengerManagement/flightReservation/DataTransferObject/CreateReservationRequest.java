package com.passengerManagement.flightReservation.DataTransferObject;

import java.sql.Timestamp;
import java.util.Date;

public class CreateReservationRequest {

	private int flightId;
	private String passengerFirstName;
	private String passengerLastName;
	private String passengerMiddleName;
	private String passengerEmail;
	private String passengerPhone;
	private String passengerCardNumber;
	private String passengerCardExpiryDate;
	private String passengerCardSecurityCode;
	private Date created = null;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getPassengerFirstName() {
		return passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerMiddleName() {
		return passengerMiddleName;
	}

	public void setPassengerMiddleName(String passengerMiddleName) {
		this.passengerMiddleName = passengerMiddleName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	public String getPassengerCardNumber() {
		return passengerCardNumber;
	}

	public void setPassengerCardNumber(String passengerCardNumber) {
		this.passengerCardNumber = passengerCardNumber;
	}

	public String getPassengerCardExpiryDate() {
		return passengerCardExpiryDate;
	}

	public void setPassengerCardExpiryDate(String passengerCardExpiryDate) {
		this.passengerCardExpiryDate = passengerCardExpiryDate;
	}

	public String getPassengerCardSecurityCode() {
		return passengerCardSecurityCode;
	}

	public void setPassengerCardSecurityCode(String passengerCardSecurityCode) {
		this.passengerCardSecurityCode = passengerCardSecurityCode;
	}
	
	public Date getCreated() {
		if(this.created == null) {
			return new Timestamp(System.currentTimeMillis());
		}else {
			return this.created;
		}
		
	}

	public void setCreated(Date created) {
		if(created == null) {
			this.created = new Timestamp(System.currentTimeMillis());
		}else {
			this.created = created;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateReservationRequest [flightId=");
		builder.append(flightId);
		builder.append(", passengerFirstName=");
		builder.append(passengerFirstName);
		builder.append(", passengerLastName=");
		builder.append(passengerLastName);
		builder.append(", passengerMiddleName=");
		builder.append(passengerMiddleName);
		builder.append(", passengerEmail=");
		builder.append(passengerEmail);
		builder.append(", passengerPhone=");
		builder.append(passengerPhone);
		builder.append(", passengerCardNumber=");
		builder.append(passengerCardNumber);
		builder.append(", passengerCardExpiryDate=");
		builder.append(passengerCardExpiryDate);
		builder.append(", passengerCardSecurityCode=");
		builder.append(passengerCardSecurityCode);
		builder.append(", created=");
		builder.append(created);
		builder.append("]");
		return builder.toString();
	}

}
