package com.passengerManagement.com.flightReservation.DataTransferObject;

public class ReservationUpdateRequest {

	private Integer reservationId;
	private Boolean reservationCheckedIn;
	private Integer  reservationNumberOfBags;

	public ReservationUpdateRequest() {
		
	}
	
	public ReservationUpdateRequest(Integer reservationId, Boolean reservationCheckedIn,
			Integer reservationNumberOfBags) {
		this.reservationId = reservationId;
		this.reservationCheckedIn = reservationCheckedIn;
		this.reservationNumberOfBags = reservationNumberOfBags;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Boolean getReservationCheckedIn() {
		return reservationCheckedIn;
	}

	public void setReservationCheckedIn(Boolean checkedIn) {
		this.reservationCheckedIn = checkedIn;
	}

	public Integer  getReservationNumberOfBags() {
		return reservationNumberOfBags;
	}

	public void setReservationNumberOfBags(Integer  numberOfBags) {
		this.reservationNumberOfBags = numberOfBags;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReservationUpdateRequest [reservationId=");
		builder.append(reservationId);
		builder.append(", reservationCheckedIn=");
		builder.append(reservationCheckedIn);
		builder.append(", reservationNumberOfBags=");
		builder.append(reservationNumberOfBags);
		builder.append("]");
		return builder.toString();
	}
}
