package com.hung.qlns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hung.qlns.model.Employee;
import com.hung.qlns.service.EmployeeDepartmentService;

@RestController
@RequestMapping("/api")
public class EmployeeDepartmentController {

	@Autowired
	private EmployeeDepartmentService emDeService;

	@GetMapping("/assign-department/{id}")
	public ResponseEntity<Object> assignDepartment(@PathVariable("id") Long deId, @RequestBody Employee employee) {
		if (emDeService.isValid(deId, employee)) {
			if (emDeService.isUnique(employee)) {
				return new ResponseEntity<Object>(emDeService.assignDepartment(deId, employee), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(emDeService.update(deId, employee), HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

}
