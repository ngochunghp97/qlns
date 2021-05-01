package com.hung.qlns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hung.qlns.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
