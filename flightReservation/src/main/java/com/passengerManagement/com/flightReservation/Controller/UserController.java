package com.passengerManagement.com.flightReservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.passengerManagement.com.flightReservation.Entity.User;
import com.passengerManagement.com.flightReservation.Repository.UserRepository;

@Controller
public class UserController {

	private static final Logger userLOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String index() {
		UserController.userLOGGER.info("Method:index()");
		return "index";
	}

	@RequestMapping("/userRegistrationForm")
	public String userRegisterationForm() {
		UserController.userLOGGER.info("Method:userRegisterationForm()");
		return "login/userRegistrationForm";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, ModelMap modelMap) {
		if (!user.getUserEmail().isBlank() && !user.getUserPassword().isBlank() && !user.getUserFirstName().isBlank()) {
			modelMap.addAttribute("userCreated", this.userRepository.save(user));
		} else {
			modelMap.addAttribute("alert", "<hr>Invalid user Details <br>Enter other credentials!<br><hr>");
			return "login/userRegistrationForm";
		}
		UserController.userLOGGER.info("Method:registerUser({})" + user);
		return "login/login";
	}

	@RequestMapping("/viewAllRegisteredUsers")
	public String viewAllRegisteredUsers(ModelMap modelMap) {
		modelMap.addAttribute("listOfAllUsers", this.userRepository.findAll());
		UserController.userLOGGER.info("Method:viewAllRegisteredUsers()");
		return "login/viewAllRegisteredUsers";
	}

	@RequestMapping("/loginShow")
	public String loginShow() {
		UserController.userLOGGER.info("Method:loginShow()");
		return "login/login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String userPassword,
			ModelMap modelMap) {
		if (!userEmail.isBlank() && !userPassword.isBlank()) {
			if (this.userRepository.findByUserEmail(userEmail).getUserPassword().equals(userPassword)) {
				UserController.userLOGGER.info("Method:login()->Blank Credentials");
				return "flights/findFlights";
			} else {
				modelMap.addAttribute("alert", "<hr>" + userEmail + " <br>Invalid Email or Password<br><hr>");
				UserController.userLOGGER.error("ERROR!");
				UserController.userLOGGER.warn("WARNING!");
				UserController.userLOGGER.info("INFO!");
				UserController.userLOGGER.debug("DEBUG!");
				UserController.userLOGGER.trace("TRACE!");
			}
		}
		UserController.userLOGGER.info("Method:login()");
		return "login/login";
	}
}
