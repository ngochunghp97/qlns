package com.hung.qlns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hung.qlns.model.Employee;
import com.hung.qlns.model.EmployeeDepartment;

@Repository
public interface EmployeeDepartmentRepositiory extends JpaRepository<EmployeeDepartment, Long> {
	EmployeeDepartment findByEmployee(Employee employee);

}
