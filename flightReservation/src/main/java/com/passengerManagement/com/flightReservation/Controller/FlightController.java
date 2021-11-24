package com.passengerManagement.com.flightReservation.Controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.passengerManagement.com.flightReservation.Entity.Flight;
import com.passengerManagement.com.flightReservation.Repository.FlightRepository;

@Controller
public class FlightController {

	private static final Logger flightLOGGER =LoggerFactory.getLogger(FlightController.class);
	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("departureCity") String departureCity,
			@RequestParam("arrivalCity") String arrivalCity,
			@RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateOfDeparture,
			ModelMap modelMap) {
		if (!departureCity.isBlank() && !arrivalCity.isBlank() && dateOfDeparture != null) {
			List<Flight> flights = this.flightRepository
					.findByDepartureCityAndArrivalCityAndDateOfDeparture(departureCity, arrivalCity, dateOfDeparture);

			if (flights.size() > 0) {
				modelMap.addAttribute("availableFlightsList", flights);
				FlightController.flightLOGGER.info("Method:findFlights()->Flights Found");
				return "flights/availableFlights";
			} else {
				modelMap.addAttribute("alert", "<hr>NO Flights Are Available!<hr>");
				FlightController.flightLOGGER.info("Method:findFlights()->Flights Not Found");
				return "flights/availableFlights";
			}

		} else {
			modelMap.addAttribute("alert", "<hr>Not a valid Input!<hr>");
			FlightController.flightLOGGER.info("Method:findFlights()-> Invalid Input Values");
			return "flights/findFlights";
		}

	}

	@RequestMapping("/searchAgian")
	public String searchAgian() {
		FlightController.flightLOGGER.info("Method:searchAgian()");
		return "flights/findFlights";
	}

	@RequestMapping("flightReservationForm")
	public String flightReservationForm(@RequestParam("flightId") Integer flightId, ModelMap modelMap) {
		modelMap.addAttribute("reserveFlight", (Flight) this.flightRepository.getById(flightId));
		FlightController.flightLOGGER.info("Method:flightReservationForm()");
		return "reservation/flightReservationForm";
	}
	
	@RequestMapping("/viewAllFlights")
	public String viewAllFlights(ModelMap modelMap) {
		modelMap.addAttribute("viewAllFlights", this.flightRepository.findAll());
		FlightController.flightLOGGER.info("Method:viewAllFlights()");
		return "flights/viewAllFlights";
	}

}
