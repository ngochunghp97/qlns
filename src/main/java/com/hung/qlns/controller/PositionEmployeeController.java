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
import com.hung.qlns.service.PositionEmployeeService;

@RestController
@RequestMapping("/api")
public class PositionEmployeeController {

	@Autowired
	private PositionEmployeeService posEmService;

	@GetMapping("/assign-position/{id}")
	public ResponseEntity<Object> assignPosition(@PathVariable("id") Long posId, @RequestBody Employee employee) {
		if (posEmService.isValid(posId, employee)) {
			if (posEmService.isUnique(employee)) {
				return new ResponseEntity<Object>(posEmService.assignPosition(posId, employee), HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(posEmService.update(posId, employee), HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

//	@GetMapping("/all-position-employee")
//	public ResponseEntity<Object> allPositionEmployee(){
//		return new ResponseEntity<Object>(posEmService.allPositionEmployee(), HttpStatus.OK);
//	}
//	
//	@GetMapping("/get-posEmployee/{id}")
//	public ResponseEntity<Object> getPosEmployee(@PathVariable("id") Long id){
//		return new ResponseEntity<Object>(posEmService.getPosEmployee(id), HttpStatus.OK);
//	}

//	@GetMapping("/assign-position/{id}")
//	public void assignPosition(@PathVariable("id") Long emId, @RequestBody Position position) {
//		Optional<Employee> emp = emRepository.findById(emId);
//		Optional<Position> pos = posRepository.findById(position.getPosId());
//		
//		PositionEmployee pe = new PositionEmployee();
//		pe.setEmployee(emp.get());
//		pe.setPosition(pos.get());
//		posEmRepository.save(pe);
//	}

}
