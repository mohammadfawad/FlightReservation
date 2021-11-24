package com.passengerManagement.com.flightReservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.passengerManagement.com.flightReservation.DataTransferObject.ReservationRequest;
import com.passengerManagement.com.flightReservation.Entity.Reservation;
import com.passengerManagement.com.flightReservation.Service.ReservationService;

@Controller
public class ReservationController {

	private static final Logger reservationLOGGER =LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST )
	public String completeReservation(ReservationRequest reservationRequest, ModelMap modelMap) {
		modelMap.addAttribute("completedReservations", (Reservation) this.reservationService.bookFlight(reservationRequest));
		ReservationController.reservationLOGGER.info("Method:completeReservation()" + reservationRequest);
		return "reservation/completeReservation";
	}
	
	
}
