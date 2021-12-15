package com.passengerManagement.flightReservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.passengerManagement.flightReservation.Entity.User;
import com.passengerManagement.flightReservation.Repository.UserRepository;

@Service
public class UserDetailServiceImplimentation implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepository.findByUserEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found for email :: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(), user.getRoles());
	}


}
