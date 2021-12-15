package com.passengerManagement.flightReservation.Service;

import java.sql.Timestamp;
import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.passengerManagement.flightReservation.DataTransferObject.ReservationRequest;
import com.passengerManagement.flightReservation.Entity.Flight;
import com.passengerManagement.flightReservation.Entity.Passenger;
import com.passengerManagement.flightReservation.Entity.Reservation;
import com.passengerManagement.flightReservation.Repository.FlightRepository;
import com.passengerManagement.flightReservation.Repository.PassengerRepository;
import com.passengerManagement.flightReservation.Repository.ReservationRepository;
import com.passengerManagement.flightReservation.Utility.EmailUtility;
import com.passengerManagement.flightReservation.Utility.PDFGenerator;

@Service
public class ReservationServiceImplimentation implements ReservationService {

	@Value("${com.passengerManagement.flightReservation.itinerary.dirPath}")
	private String PASSENGER_RESERVATION_PATH_PDF;
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
	@Transactional
	public Reservation bookFlight(ReservationRequest reservationRequest) {
		// TODO Auto-generated method stub
		// MAKE PAYMENT THROUGH PAYMENT GATEWAY NOT IMPLIMENTED THEN BELOW PROCESS
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
		String filePath = this.PASSENGER_RESERVATION_PATH_PDF + savedReservation.getReservationId().toString() + ".pdf";
		this.pdfGenerator.generateItinerary(savedReservation, filePath);
		this.emailUtility.sendItinerary(passenger.getPassengerEmail(), filePath);
		ReservationServiceImplimentation.ReservationServiceLOGGER.info("Method:bookFlight()->SavedReservation + PDF and Email Generated.");
		
		return savedReservation;
	}

}
