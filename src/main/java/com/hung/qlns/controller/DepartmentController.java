package com.hung.qlns.controller;

import java.util.List;

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

import com.hung.qlns.dto.DepartmentDTO;
import com.hung.qlns.dto.ResponseData;
import com.hung.qlns.model.Department;
import com.hung.qlns.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deService;
	
	@GetMapping("/department")
	public ResponseEntity<Department> allDepartment(){
		List<Department> deList = deService.allDepartments();
		return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), deList),HttpStatus.OK);
	}
	
	@GetMapping("/department/{id}")
	public ResponseEntity<Object> getDepartment(Long deId){
		return new ResponseEntity<Object>(deService.getDepartment(deId), HttpStatus.OK);
	}
	
	@PostMapping("/department")
	public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentInput){
		Department department = deService.createDepartment(departmentInput);
		return new ResponseEntity(new ResponseData(HttpStatus.OK.value(), department), HttpStatus.OK);
	}
	
	@PutMapping("/department/{id}")
	public ResponseEntity<Object> updateDepartment(@PathVariable("id") Long deId, @RequestBody  Department department){
		if(deService.isValid(deId)) {
			return new ResponseEntity<Object>(deService.updateDepartment(department, deId), HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Object> deleteDepartment(@PathVariable("id") Long deId, @RequestBody Department department){
		if(deService.isValid(deId)) {
			return new ResponseEntity<Object>(deService.deleteDepartment(deId), HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	
}
