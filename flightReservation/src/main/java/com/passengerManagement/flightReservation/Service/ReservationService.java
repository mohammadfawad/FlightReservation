package com.passengerManagement.flightReservation.Service;

import com.passengerManagement.flightReservation.DataTransferObject.ReservationRequest;
import com.passengerManagement.flightReservation.Entity.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest reservationRequest);
}
