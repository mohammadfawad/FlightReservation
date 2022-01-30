package com.passengerManagement.flightReservation.Controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.passengerManagement.flightReservation.DataTransferObject.CreateReservationRequest;
import com.passengerManagement.flightReservation.DataTransferObject.ReservationUpdateRequest;
import com.passengerManagement.flightReservation.Entity.Flight;
import com.passengerManagement.flightReservation.Entity.Passenger;
import com.passengerManagement.flightReservation.Entity.Reservation;
import com.passengerManagement.flightReservation.Repository.FlightRepository;
import com.passengerManagement.flightReservation.Repository.PassengerRepository;
import com.passengerManagement.flightReservation.Repository.ReservationRepository;

@RestController
@CrossOrigin(origins = "*")
public class ReservationRestController {

	private static final Logger reservationRestLOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/reservations/{reservationId}", method = RequestMethod.GET)
	public Reservation findReservation(@PathVariable("reservationId") Integer reservationId) {
		ReservationRestController.reservationRestLOGGER.info("Method:findReservation({})" + reservationId.toString());
		return this.reservationRepository.getById(reservationId);
	}

	@RequestMapping(value = "/reservations", method = RequestMethod.PUT)
	@Transactional
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest reservationUpdateRequest) {
		Reservation reservation = this.reservationRepository.getById(reservationUpdateRequest.getReservationId());
		reservation.setReservationCheckedIn(reservationUpdateRequest.getReservationCheckedIn());
		reservation.setReservationNumberOfBags(reservationUpdateRequest.getReservationNumberOfBags());
		ReservationRestController.reservationRestLOGGER.info("Method:updateReservation()" + reservationUpdateRequest);
		return this.reservationRepository.save(reservation);
	}

	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	public List<Flight> findFlights(@RequestParam("departureCity") String departureCity,
			@RequestParam("arrivalCity") String arrivalCity,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM/dd/yyyy") Date departureDate) {
		// System.out.print(departureCity+"" + arrivalCity +""+ departureDate);
		// http://localhost:8082/flightReservation/flights?departureCity=AUS&arrivalCity=NYC&departureDate=02/05/2018
		ReservationRestController.reservationRestLOGGER.info("Method:findFlights() " + departureDate);
		return this.flightRepository.findByDepartureCityAndArrivalCityAndDateOfDeparture(departureCity, arrivalCity,
				departureDate);
	}
	
	@RequestMapping(value = "/flights/{flightId}", method = RequestMethod.GET)
	public Flight findFlightByflightId(@PathVariable("flightId") Integer flightId) {
		return this.flightRepository.getById(flightId);
	}

	@RequestMapping(value = "/createreservation", method = RequestMethod.POST)
	@Transactional
	public Reservation createNewReservation(@RequestBody CreateReservationRequest createReservationRequest) {

		Flight flight = this.flightRepository.getById(createReservationRequest.getFlightId());

		Passenger passenger = new Passenger();
		passenger.setPassengerFirstName(createReservationRequest.getPassengerFirstName());
		passenger.setPassengerMiddleName(createReservationRequest.getPassengerMiddleName());
		passenger.setPassengerLastName(createReservationRequest.getPassengerLastName());
		passenger.setPassengerEmail(createReservationRequest.getPassengerEmail());
		passenger.setPassengerPhone(createReservationRequest.getPassengerPhone());
		Passenger savedPassenger = this.passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setReservationFlightId(flight);
		reservation.setReservationPassengerId(savedPassenger);
		reservation.setCreated(reservation.getCreated());
		reservation.setReservationCheckedIn(false);
		ReservationRestController.reservationRestLOGGER.info("Method:createreservation() " + createReservationRequest);
		return this.reservationRepository.save(reservation);
	}
}
