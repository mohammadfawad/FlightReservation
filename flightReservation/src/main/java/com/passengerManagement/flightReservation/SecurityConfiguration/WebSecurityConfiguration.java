package com.passengerManagement.flightReservation.SecurityConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeRequests()
				.antMatchers("/", "/index", "/userRegistrationForm", "/loginShow", "/login", "/viewAllFlights",
						"/registerUser", "/reservations/*", "/flights", "/flights/*", "/completeReservation", "/reservations",
						"/createreservation", "/findFlights")
				.permitAll().antMatchers("/admin/*", "/viewAllRegisteredUsers", "/showAddFlight")
				.hasAnyAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
}
