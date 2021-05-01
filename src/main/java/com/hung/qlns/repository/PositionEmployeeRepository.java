package com.hung.qlns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hung.qlns.model.Employee;
import com.hung.qlns.model.PositionEmployee;

@Repository
public interface PositionEmployeeRepository extends JpaRepository<PositionEmployee, Long> {
	PositionEmployee findByEmployee(Employee employee);
}
