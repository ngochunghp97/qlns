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

import com.hung.qlns.model.User;
import com.hung.qlns.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService uService;
	
	@GetMapping("/user")
	public ResponseEntity<Object> allUser(){
		return new ResponseEntity<Object>(uService.allUser(),HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") Long userId){
		return new ResponseEntity<Object>(uService.getUser(userId), HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		if(uService.isValidUserName(user.getUserName())) {
		return new ResponseEntity<Object>(uService.createUser(user),HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(HttpStatus.FOUND);
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
		if(uService.isValid(userId)) {
			if(uService.isValidUserName(user.getUserName())) {
			return new ResponseEntity<Object>(uService.updateUser(userId, user), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.FOUND);
			}
		}else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") Long userId, @RequestBody User user){
		if(uService.isValid(userId)) {
			return new ResponseEntity<Object>(uService.deleteUser(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
}
