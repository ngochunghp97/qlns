package com.hung.qlns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hung.qlns.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
