package com.passengerManagement.com.flightReservation.Service;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passengerManagement.com.flightReservation.DataTransferObject.ReservationRequest;
import com.passengerManagement.com.flightReservation.Entity.Flight;
import com.passengerManagement.com.flightReservation.Entity.Passenger;
import com.passengerManagement.com.flightReservation.Entity.Reservation;
import com.passengerManagement.com.flightReservation.Repository.FlightRepository;
import com.passengerManagement.com.flightReservation.Repository.PassengerRepository;
import com.passengerManagement.com.flightReservation.Repository.ReservationRepository;
import com.passengerManagement.com.flightReservation.Utility.EmailUtility;
import com.passengerManagement.com.flightReservation.Utility.PDFGenerator;

@Service
public class ReservationServiceImplimentation implements ReservationService {

	private static final Logger ReservationServiceLOGGER =LoggerFactory.getLogger(ReservationServiceImplimentation.class);
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	PDFGenerator pdfGenerator;
	@Autowired
	EmailUtility emailUtility;
	
	@Override
	public Reservation bookFlight(ReservationRequest reservationRequest) {
		// TODO Auto-generated method stub
		// MAKE PAYMENT THROUGH PAYMENT GATEWAY
		ReservationServiceImplimentation.ReservationServiceLOGGER.info("Method:bookFlight()->Fetch Flight Details from dataBase.");
		Flight flight = this.flightRepository.getById(reservationRequest.getFlightId());
		
		Passenger passenger = new Passenger();
		passenger.setPassengerFirstName(reservationRequest.getPassengerFirstName());
		passenger.setPassengerLastName(reservationRequest.getPassengerLastName());
		passenger.setPassengerEmail(reservationRequest.getPassengerEmail());
		passenger.setPassengerPhone(reservationRequest.getPassengerPhone());
		Passenger savedPassenger = this.passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setReservationFlightId(flight);
		reservation.setReservationPassengerId(savedPassenger);
		reservation.setReservationCheckedIn(false);
		reservation.setCreated(new Timestamp(new Date().getTime()));
		
		Reservation savedReservation = this.reservationRepository.save(reservation);
		String filePath = "/home/spring/EclipseSTS/flightReservation/src/main/webapp/WEB-INF/views/passengerPdf/passengersPdf" + savedReservation.getReservationId().toString() + ".pdf";
		this.pdfGenerator.generateItinerary(savedReservation, filePath);
		this.emailUtility.sendItinerary(passenger.getPassengerEmail(), filePath);
		ReservationServiceImplimentation.ReservationServiceLOGGER.info("Method:bookFlight()->SavedReservation + PDF and Email Generated.");
		
		return savedReservation;
	}

}
