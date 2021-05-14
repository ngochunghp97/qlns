package com.hung.qlns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.qlns.dto.DepartmentDTO;
import com.hung.qlns.model.Department;
import com.hung.qlns.model.Position;
import com.hung.qlns.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository deRepository;

	public boolean isValid(Long deId) {
		Optional<Department> de = deRepository.findById(deId);
		return de.isPresent();
	}

	public List<Department> allDepartments() {
		return deRepository.findAll();
	}

	public Optional<Department> getDepartment(Long deId) {
		return deRepository.findById(deId);
	}

	public Department createDepartment(DepartmentDTO departmentInput) {
		Department de = new Department();
		de.setDeName(departmentInput.getDeName());
		de.setDeCode(departmentInput.getDeCode());
		de.setDeDesc(departmentInput.getDeDesc());

		deRepository.save(de);
		return de;
	}

	public Department updateDepartment(Long deId, DepartmentDTO departmentInput) {
		Optional<Department> de = deRepository.findById(deId);
		if(de.isPresent()) {
			Department nDe = de.get();
			nDe.setDeName(departmentInput.getDeName());
			nDe.setDeCode(departmentInput.getDeCode());
			nDe.setDeDesc(departmentInput.getDeDesc());
			deRepository.save(nDe);

			return nDe;
		}else {
			return null;
		}		
	}

	public boolean deleteDepartment(Long deId) {
		Optional<Department> de = deRepository.findById(deId);
		if(de.isPresent()) {
			Department d= de.get();
			deRepository.delete(d);
			return true;
		}else {
			return false;
		}
	}

}
