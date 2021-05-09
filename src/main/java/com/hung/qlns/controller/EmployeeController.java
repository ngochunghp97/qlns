package com.hung.qlns.controller;

import java.util.List;
import java.util.Optional;

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

import com.hung.qlns.dto.EmPosDeProjection;
import com.hung.qlns.dto.EmployeeDTO;
import com.hung.qlns.dto.ResponseData;
import com.hung.qlns.model.Employee;
import com.hung.qlns.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService emService;

	@GetMapping("/employee")
	public ResponseEntity<Employee> allEmployee() {
		List<Employee> emList = emService.allEmployee();
		return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), emList), HttpStatus.OK);
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long emId){
		Optional<Employee> em = emService.getEmployee(emId);
		Employee e = em.get();
		if (emService.isValid(emId)) {
			return new ResponseEntity(new ResponseData(HttpStatus.OK.value(),e),HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeInput) {
		Employee employee = emService.createEmployee(employeeInput);
		return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), employee), HttpStatus.OK);
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long emId) {
		if (emService.isValid(emId)) {
			return new ResponseEntity<Object>(emService.updateEmployee(employee, emId), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/employees/{emId}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("emId") Long emId) {
		Boolean isDelete = emService.deleteEmployee(emId);
		return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), isDelete),HttpStatus.OK);
//		return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), "false"),HttpStatus.OK);
		

	}
	

	@GetMapping("/employee/pos-detail/{id}")
	public ResponseEntity<Employee> getEmPos(@PathVariable("id") Long emId) {
		if (emService.isValid(emId)) {
			EmPosDeProjection em = emService.getEmPos(emId);
			return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), em), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/employee/de-detail/{id}")
	public ResponseEntity<Employee> getEmDe(@PathVariable("id") Long emId) {
		if (emService.isValid(emId)) {
			EmPosDeProjection em = emService.getEmDe(emId);
			return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), em), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
