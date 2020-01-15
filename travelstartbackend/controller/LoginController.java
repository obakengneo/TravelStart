package main.travelstartbackend.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.travelstartbackend.model.User;
import main.travelstartbackend.service.UserService;
import main.travelstartbackend.util.CustomErrorType;

@RestController
@RequestMapping("account")
public class LoginController 
{

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) 
	{
		if (userService.find(user.getUsername()) != null) {
			logger.error("Username already exist " + user.getUsername());
			return new ResponseEntity(new CustomErrorType("User with username " + user.getUsername() + "already exist "),HttpStatus.CONFLICT);
		}
		user.setRole("USER");
		
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Principal user(Principal principal) 
	{
		logger.info("User logged "+principal);
		return principal;
	}
}
