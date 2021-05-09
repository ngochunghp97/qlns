package com.hung.qlns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hung.qlns.dto.PositionEmployeeDTO;
import com.hung.qlns.dto.ResponseData;
import com.hung.qlns.model.PositionEmployee;
import com.hung.qlns.service.PositionEmployeeService;

@RestController
@RequestMapping("/api")
public class PositionEmployeeController {

	@Autowired
	private PositionEmployeeService posEmService;

	@PostMapping("/assign-position")
	public ResponseEntity<PositionEmployee> assignPosition(@RequestBody PositionEmployeeDTO posEmInput) {
		if (posEmService.isValid(posEmInput)) {
			if (posEmService.isUnique(posEmInput)) {
				PositionEmployee poE = posEmService.assignPosition(posEmInput);
				return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), poE), HttpStatus.OK);
			}else {
				PositionEmployee poEm = posEmService.update(posEmInput);
				return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), poEm), HttpStatus.OK);
			}
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
