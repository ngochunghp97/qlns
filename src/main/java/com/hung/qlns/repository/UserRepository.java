package com.hung.qlns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hung.qlns.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);

}
