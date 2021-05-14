package com.hung.qlns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.qlns.dto.EmployeeDepartmentDTO;
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

	public boolean isValid(EmployeeDepartmentDTO emDeInput) {
		Optional<Employee> em = emRepository.findById(emDeInput.getEmId());
		Optional<Department> de = deRepository.findById(emDeInput.getDeId());

		return em.isPresent() && de.isPresent();
	}

	public boolean isUnique(EmployeeDepartmentDTO emDeInput) {
		Optional<Employee> e = emRepository.findById(emDeInput.getEmId());
		Employee em = e.get();
		return emDeRepositiory.findByEmployee(em) == null;
	}

	public EmployeeDepartment assignDepartment(EmployeeDepartmentDTO emDeInput) {
		Optional<Employee> em = emRepository.findById(emDeInput.getEmId());
		Optional<Department> de = deRepository.findById(emDeInput.getDeId());

		EmployeeDepartment ed = new EmployeeDepartment();
		ed.setEmployee(em.get());
		ed.setDepartment(de.get());
		emDeRepositiory.save(ed);
		return ed;
	}

	public EmployeeDepartment update(EmployeeDepartmentDTO emDeInput) {
		Optional<Department> de = deRepository.findById(emDeInput.getDeId());
		Optional<Employee> em = emRepository.findById(emDeInput.getEmId());
		Employee e = em.get();

		EmployeeDepartment ed = emDeRepositiory.findByEmployee(e);
		ed.setDepartment(de.get());
		emDeRepositiory.save(ed);
		return ed;
	}
}
