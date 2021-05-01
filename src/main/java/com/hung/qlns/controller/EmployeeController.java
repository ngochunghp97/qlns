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

import com.hung.qlns.model.Employee;
import com.hung.qlns.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService emService;

	@GetMapping("/employee")
	public ResponseEntity<Object> allEmployee() {
		
		return new ResponseEntity<Object>(emService.allEmployee(), HttpStatus.OK);
	}

	@PostMapping("/employee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Object>(emService.createEmployee(employee), HttpStatus.OK);
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long emId) {
		if (emService.isValid(emId)) {
			return new ResponseEntity<Object>(emService.updateEmployee(employee, emId), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long emId) {
		if (emService.isValid(emId)) {
			return new ResponseEntity<Object>(emService.deleteEmployee(emId), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}

	}
}
