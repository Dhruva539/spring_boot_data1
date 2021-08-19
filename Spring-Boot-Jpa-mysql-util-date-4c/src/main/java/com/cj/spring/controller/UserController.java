package com.cj.spring.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cj.spring.bean.User;
import com.cj.spring.service.UserService;

@RestController
@RequestMapping(value = { "/user" })
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getName()+ user.getCreateddatetime());
		userService.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/usersbydatetimebetween")
	public List<User> getAllByDatetimeBetween(
			@RequestParam("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startdate,
			@RequestParam("enddate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date enddate) {

		return userService.findAllByCreatedbatetimeBetween(startdate, enddate);
	}

	@GetMapping("/userswithdatetimebefore")
	public List<User> getAllWithDatetimeBefore(
			@RequestParam("datetime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date datetime) {

		return userService.findAllWithCreateddatetimeBefore(datetime);
	}
}
