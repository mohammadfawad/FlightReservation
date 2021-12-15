package com.passengerManagement.flightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passengerManagement.flightReservation.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
