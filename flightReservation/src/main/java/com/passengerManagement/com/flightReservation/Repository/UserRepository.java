package com.passengerManagement.com.flightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passengerManagement.com.flightReservation.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserEmail(String userEmail);
}
