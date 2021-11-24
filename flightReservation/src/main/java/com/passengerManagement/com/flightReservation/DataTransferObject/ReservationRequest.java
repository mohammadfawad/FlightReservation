package com.passengerManagement.com.flightReservation.DataTransferObject;

public class ReservationRequest {

	private Integer flightId;
	private String passengerFirstName;
	private String passengerLastName;
	private String passengerEmail;
	private String passengerPhone;
	private String nameOnCard;
	private String cardNo;
	private String expiryDate;
	private String securityCode;

	/**
	 * @return the flightId
	 */
	public Integer getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	/**
	 * @return the passengerFirstName
	 */
	public String getPassengerFirstName() {
		return passengerFirstName;
	}

	/**
	 * @param passengerFirstName the passengerFirstName to set
	 */
	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	/**
	 * @return the passengerLastName
	 */
	public String getPassengerLastName() {
		return passengerLastName;
	}

	/**
	 * @param passengerLastName the passengerLastName to set
	 */
	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	/**
	 * @return the passengerEmail
	 */
	public String getPassengerEmail() {
		return passengerEmail;
	}

	/**
	 * @param passengerEmail the passengerEmail to set
	 */
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	/**
	 * @return the passengerPhone
	 */
	public String getPassengerPhone() {
		return passengerPhone;
	}

	/**
	 * @param passengerPhone the passengerPhone to set
	 */
	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	/**
	 * @return the nameOnCard
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * @param nameOnCard the nameOnCard to set
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the securityCode
	 */
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * @param securityCode the securityCode to set
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReservationRequest [flightId=");
		builder.append(flightId);
		builder.append(", passengerFirstName=");
		builder.append(passengerFirstName);
		builder.append(", passengerLastName=");
		builder.append(passengerLastName);
		builder.append(", passengerEmail=");
		builder.append(passengerEmail);
		builder.append(", passengerPhone=");
		builder.append(passengerPhone);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append(", cardNo=");
		builder.append(cardNo);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", securityCode=");
		builder.append(securityCode);
		builder.append("]");
		return builder.toString();
	}

}
