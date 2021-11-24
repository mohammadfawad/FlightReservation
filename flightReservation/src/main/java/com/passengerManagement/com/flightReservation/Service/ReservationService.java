package com.passengerManagement.com.flightReservation.Service;

import com.passengerManagement.com.flightReservation.DataTransferObject.ReservationRequest;
import com.passengerManagement.com.flightReservation.Entity.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest reservationRequest);
}
