package com.hung.qlns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hung.qlns.dto.EmPosDeProjection;
import com.hung.qlns.dto.EmpAllProjection;
import com.hung.qlns.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "select e.em_id emId, e.name, e.birthday, e.start_date startDate, e.end_date endDate, e.experience, e.language, e.computer, e.major, e.gender, p.pos_name posName, d.de_name deName from employee e \r\n"
			+ "join position_employee po on e.em_id = po.em_id\r\n" + "join position p on po.pos_id = p.pos_id\r\n"
			+ "join employee_department emd on e.em_id = emd.em_id\r\n"
			+ "join department d on d.de_id = emd.de_id", nativeQuery = true)
	List<EmPosDeProjection> getEmPosDe();

	@Query(value = "select em_id emId, name, birthday, address, start_date startDate, end_date endDate, experience, language, computer, major, gender from employee", nativeQuery = true)
	List<EmpAllProjection> getEmAll();

	@Query(value = "select em_id emId, name, birthday, address, start_date startDate, end_date endDate, experience, language, computer, major, gender from employee where em_id = ?1", nativeQuery = true)
	EmpAllProjection getEmployeeDetail(Long emId);

	@Query(value = "select p.pos_name posName from employee e\r\n" + "join position_employee po on e.em_id = po.em_id\r\n"
			+ "join position p on po.pos_id = p.pos_id\r\n" + "where e.em_id = ?1", nativeQuery = true)
	EmPosDeProjection getEmPos(Long emId);

	@Query(value = "select d.de_name deName from employee e\r\n" + "join employee_department ed on e.em_id = ed.em_id\r\n"
			+ "join department d on ed.de_id = d.de_id\r\n" + "where e.em_id = ?1", nativeQuery = true)
	EmPosDeProjection getEmDe(Long emId);

}
