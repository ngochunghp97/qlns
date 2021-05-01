package com.hung.qlns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.qlns.model.Department;
import com.hung.qlns.model.Employee;
import com.hung.qlns.model.EmployeeDepartment;
import com.hung.qlns.repository.DepartmentRepository;
import com.hung.qlns.repository.EmployeeDepartmentRepositiory;
import com.hung.qlns.repository.EmployeeRepository;

@Service
public class EmployeeDepartmentService {

	@Autowired
	private EmployeeRepository emRepository;
	@Autowired
	private DepartmentRepository deRepository;
	@Autowired
	private EmployeeDepartmentRepositiory emDeRepositiory;

	public boolean isValid(Long deId, Employee employee) {
		Optional<Employee> em = emRepository.findById(employee.getEmId());
		Optional<Department> de = deRepository.findById(deId);

		return em.isPresent() && de.isPresent();
	}

	public boolean isUnique(Employee employee) {
		return emDeRepositiory.findByEmployee(employee) == null;
	}

	public EmployeeDepartment assignDepartment(Long deId, Employee employee) {
		Optional<Employee> em = emRepository.findById(employee.getEmId());
		Optional<Department> de = deRepository.findById(deId);

		EmployeeDepartment ed = new EmployeeDepartment();
		ed.setEmployee(em.get());
		ed.setDepartment(de.get());
		emDeRepositiory.save(ed);
		return null;
	}

	public EmployeeDepartment update(Long deId, Employee employee) {
		Optional<Department> de = deRepository.findById(deId);

		EmployeeDepartment ed = emDeRepositiory.findByEmployee(employee);
		ed.setDepartment(de.get());
		emDeRepositiory.save(ed);
		return null;
	}
}
