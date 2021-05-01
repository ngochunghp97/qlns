package com.hung.qlns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.qlns.model.Employee;
import com.hung.qlns.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository emRepository;

	public List<Employee> allEmployee() {
		List<Employee> emList = emRepository.findAll();
		return emList;
	}

	public Optional<Employee> getEmployee(Long emId) {
		return emRepository.findById(emId);
	}

	public Employee updateEmployee(Employee employee, Long emId) {
		Optional<Employee> emp = emRepository.findById(emId);

		Employee nEmp = emp.get();
		nEmp.setName(employee.getName());
		nEmp.setBirthDay(employee.getBirthDay());
		nEmp.setAddress(employee.getAddress());
		nEmp.setStartDate(employee.getStartDate());
		nEmp.setEndDate(employee.getEndDate());
		nEmp.setExperience(employee.getExperience());
		nEmp.setLanguage(employee.getLanguage());
		nEmp.setComputer(employee.getComputer());
		nEmp.setMajor(employee.getMajor());
		nEmp.setGender(employee.getGender());
		emRepository.save(nEmp);

		return nEmp;
	}

	public Employee createEmployee(Employee employee) {
		emRepository.save(employee);
		return employee;
	}

	public Long deleteEmployee(Long emId) {
		emRepository.deleteById(emId);
		return emId;
	}

	public boolean isValid(Long emId) {
		Optional<Employee> emp = emRepository.findById(emId);
		return emp.isPresent();
	}

}
