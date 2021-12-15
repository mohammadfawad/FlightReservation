package com.passengerManagement.flightReservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImplimentation implements SecurityService {

	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Override
	public boolean login(String userName, String userPassword) {
		// TODO Auto-generated method stub
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, userPassword, userDetails.getAuthorities());
		this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		boolean isAuthenticated = usernamePasswordAuthenticationToken.isAuthenticated();
		if(isAuthenticated) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		return isAuthenticated;
	}

}
