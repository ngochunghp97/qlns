package com.hung.qlns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hung.qlns.dto.ResponseData;
import com.hung.qlns.dto.UserDTO;
import com.hung.qlns.model.User;
import com.hung.qlns.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService uService;

	@GetMapping("/user")
	public ResponseEntity<Object> allUser() {
		return new ResponseEntity<Object>(uService.allUser(), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") Long userId) {
		return new ResponseEntity<Object>(uService.getUser(userId), HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody UserDTO userInput) {
		if (uService.isValidUserName(userInput.getUserName())) {
			User user = uService.createUser(userInput);
			return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), user), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.FOUND);
		}
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody UserDTO userInput) {
		if (uService.isValidUserName(userInput.getUserName())) {
			User user = uService.updateUser(userId, userInput);
			return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), user), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.FOUND);
		}
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long userId) {
		Boolean isDelete = uService.deleteUser(userId);
			return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), isDelete), HttpStatus.OK);
	}
}
