package com.mehulsblog.photoapp.api.users.ui.controllers;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehulsblog.photoapp.api.users.service.UsersService;
import com.mehulsblog.photoapp.api.users.shared.UserDto;
import com.mehulsblog.photoapp.api.users.ui.model.CreateUserRequestModel;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService userService;

	@Autowired
	private Environment environmnet;

	@GetMapping("/status/check")
	public String status() {
		return "User Service is Working on :" + environmnet.getProperty("local.server.port");
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
		System.out.println("userDetail is :" + userDetails.toString());
		try {

			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			UserDto userDto = modelMapper.map(userDetails, UserDto.class);
			userService.createUser(userDto);
			return ResponseEntity.ok().body(userDto);
		} catch (Exception e) {
			return ResponseEntity.ok(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
