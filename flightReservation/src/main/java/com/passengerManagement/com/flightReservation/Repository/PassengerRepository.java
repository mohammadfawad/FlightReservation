package com.passengerManagement.com.flightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passengerManagement.com.flightReservation.Entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
