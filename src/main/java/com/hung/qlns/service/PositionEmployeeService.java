package com.hung.qlns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.qlns.model.Employee;
import com.hung.qlns.model.Position;
import com.hung.qlns.model.PositionEmployee;
import com.hung.qlns.repository.EmployeeRepository;
import com.hung.qlns.repository.PositionEmployeeRepository;
import com.hung.qlns.repository.PositionRepository;

@Service
public class PositionEmployeeService {

	@Autowired
	private EmployeeRepository emRepository;
	@Autowired
	private PositionRepository posRepository;
	@Autowired
	private PositionEmployeeRepository posEmRepository;

	public PositionEmployee assignPosition(Long posId, Employee employee) {

		Optional<Position> pos = posRepository.findById(posId);
		Optional<Employee> em = emRepository.findById(employee.getEmId());

		PositionEmployee pe = new PositionEmployee();
		pe.setEmployee(em.get());
		pe.setPosition(pos.get());
		posEmRepository.save(pe);
		return null;

	}

	public PositionEmployee update(Long posId, Employee employee) {
		Optional<Position> pos = posRepository.findById(posId);

		PositionEmployee pe = posEmRepository.findByEmployee(employee);
		pe.setPosition(pos.get());
		posEmRepository.save(pe);
		return null;

	}

	public boolean isValid(Long posId, Employee employee) {
		Optional<Position> pos = posRepository.findById(posId);
		Optional<Employee> em = emRepository.findById(employee.getEmId());
		return pos.isPresent() && em.isPresent();
	}

	public boolean isUnique(Employee employee) {
		return posEmRepository.findByEmployee(employee) == null;
	}

}
