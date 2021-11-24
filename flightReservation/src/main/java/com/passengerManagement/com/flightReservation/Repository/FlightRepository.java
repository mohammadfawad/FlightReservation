package com.passengerManagement.com.flightReservation.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.passengerManagement.com.flightReservation.Entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> findByDepartureCityAndArrivalCityAndDateOfDeparture(@Param("departureCity") String departureCity,
			@Param("arrivalCity") String arrivalCity, @Param("dateOfDeparture") Date dateOfDeparture);
}
