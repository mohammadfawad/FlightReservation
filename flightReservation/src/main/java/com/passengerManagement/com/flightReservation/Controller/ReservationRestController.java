package com.passengerManagement.com.flightReservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passengerManagement.com.flightReservation.DataTransferObject.ReservationUpdateRequest;
import com.passengerManagement.com.flightReservation.Entity.Reservation;
import com.passengerManagement.com.flightReservation.Repository.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {

	private static final Logger reservationRestLOGGER =LoggerFactory.getLogger(ReservationRestController.class);
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{reservationId}")
	public Reservation findReservation(@PathVariable("reservationId") Integer reservationId) {
		ReservationRestController.reservationRestLOGGER.info("Method:findReservation({})"+reservationId.toString());
		return this.reservationRepository.getById(reservationId);
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest reservationUpdateRequest) {
		Reservation reservation = this.reservationRepository.getById(reservationUpdateRequest.getReservationId());
		reservation.setReservationCheckedIn(reservationUpdateRequest.getReservationCheckedIn());
		reservation.setReservationNumberOfBags(reservationUpdateRequest.getReservationNumberOfBags());
		ReservationRestController.reservationRestLOGGER.info("Method:updateReservation()"+reservationUpdateRequest);
		return this.reservationRepository.save(reservation);
	}
}
