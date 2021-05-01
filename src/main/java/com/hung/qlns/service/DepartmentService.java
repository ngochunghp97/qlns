package com.hung.qlns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.qlns.model.Department;
import com.hung.qlns.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository deRepository;
	
	public boolean isValid(Long deId) {
		Optional<Department> de = deRepository.findById(deId);
		return de.isPresent();
	}
	
	public List<Department> allDepartments(){
		List<Department> deList = deRepository.findAll();
		return deList;
	}
	
	public Optional<Department> getDepartment(Long deId){
		return deRepository.findById(deId);
	}
	
	public Department createDepartment(Department department) {
		deRepository.save(department);
		return department;
	}
	public Department updateDepartment(Department department, Long deId) {
		Optional<Department> de = deRepository.findById(deId);
		
		Department nDe = de.get();
		nDe.setDeName(department.getDeName());
		nDe.setDeCode(department.getDeCode());
		nDe.setDeDesc(department.getDeDesc());
		deRepository.save(nDe);
		
		return nDe;
	}
	public Long deleteDepartment(Long deId) {
		deRepository.deleteById(deId);
		return deId;
	}
	
}
