package com.hung.qlns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hung.qlns.dto.EmployeeDepartmentDTO;
import com.hung.qlns.dto.ResponseData;

import com.hung.qlns.model.EmployeeDepartment;
import com.hung.qlns.service.EmployeeDepartmentService;

@RestController
@RequestMapping("/api")
public class EmployeeDepartmentController {

	@Autowired
	private EmployeeDepartmentService emDeService;

	@PostMapping("/assign-department")
	public ResponseEntity<EmployeeDepartment> assignDepartment(@RequestBody EmployeeDepartmentDTO emDeInput) {
		if (emDeService.isValid(emDeInput)) {
			if (emDeService.isUnique(emDeInput)) {
				EmployeeDepartment emD = emDeService.assignDepartment(emDeInput);
				return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), emD), HttpStatus.OK);
			} else {
				EmployeeDepartment emD = emDeService.update(emDeInput);
				return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), emD), HttpStatus.OK);
			}
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

}
