package com.hung.qlns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.qlns.dto.PositionEmployeeDTO;
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

	public PositionEmployee assignPosition(PositionEmployeeDTO posEmInput) {

		Optional<Position> pos = posRepository.findById(posEmInput.getPosId());
		Optional<Employee> em = emRepository.findById(posEmInput.getEmId());

		PositionEmployee pe = new PositionEmployee();
		pe.setEmployee(em.get());
		pe.setPosition(pos.get());
		posEmRepository.save(pe);
		return pe;

	}

	public PositionEmployee update(PositionEmployeeDTO posEmInput) {
		Optional<Position> pos = posRepository.findById(posEmInput.getPosId());

		Optional<PositionEmployee> pe = posEmRepository.findById(posEmInput.getEmId());
		PositionEmployee pes = pe.get();
		pes.setPosition(pos.get());
		posEmRepository.save(pes);
		return pes;

	}

	public boolean isValid(PositionEmployeeDTO posEmInput) {
		Optional<Position> pos = posRepository.findById(posEmInput.getPosId());
		Optional<Employee> em = emRepository.findById(posEmInput.getEmId());
		return pos.isPresent() && em.isPresent();
	}

	public boolean isUnique(PositionEmployeeDTO posEmInput) {
		Optional<Employee> e = emRepository.findById(posEmInput.getEmId());
		Employee em = e.get();
		
		return posEmRepository.findByEmployee(em) == null;
	}

}
