package com.hung.qlns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.qlns.dto.EmPosDeProjection;
import com.hung.qlns.dto.EmpAllProjection;
import com.hung.qlns.dto.EmployeeDTO;
import com.hung.qlns.model.Employee;
import com.hung.qlns.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository emRepository;

	public List<Employee> allEmployee() {
		return emRepository.findAll();
	}

	public Optional<Employee> getEmployee(Long emId) {
		return emRepository.findById(emId);
	}

	public Employee updateEmployee(Long emId, Employee employee) {
		Optional<Employee> emp = emRepository.findById(emId);
		if(emp.isPresent()) {
			Employee nEmp = emp.get();
			nEmp.setName(employee.getName());
			nEmp.setBirthday(employee.getBirthday());
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
		}else {
			return null;			
		}		
	}

	public Employee createEmployee(EmployeeDTO employeeInput) {
		Employee em = new Employee();
		em.setName(employeeInput.getName());
		em.setBirthday(employeeInput.getBirthday());
		em.setAddress(employeeInput.getAddress());
		em.setStartDate(employeeInput.getStartDate());
		em.setEndDate(employeeInput.getEndDate());
		em.setExperience(employeeInput.getExperience());
		em.setLanguage(employeeInput.getLanguage());
		em.setComputer(employeeInput.getComputer());
		em.setMajor(employeeInput.getMajor());
		em.setGender(employeeInput.getGender());
		
		emRepository.save(em);
		return em;
	}

	public boolean deleteEmployee(Long emId) {
		Optional<Employee> em = emRepository.findById(emId);
		if(em.isPresent()) {
			Employee e = em.get();
			emRepository.delete(e);
			return true;
		}else {
			return false;
		}
		
	}

	public boolean isValid(Long emId) {
		Optional<Employee> emp = emRepository.findById(emId);
		return emp.isPresent();
	}
	
	public List<EmPosDeProjection> getEmPosDe() {
		return emRepository.getEmPosDe();
	}
	
	public List<EmpAllProjection> getEmAll(){
		return emRepository.getEmAll();
	}
	
	public EmpAllProjection getEmployeeDetail(Long emId) {
		return emRepository.getEmployeeDetail(emId);
	}
	
	public EmPosDeProjection getEmPos(Long emId) {
		return emRepository.getEmPos(emId);
	}
	public EmPosDeProjection getEmDe(Long emId) {
		return emRepository.getEmDe(emId);
	}
}
