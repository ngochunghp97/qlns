package com.hung.qlns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hung.qlns.dto.UserDTO;
import com.hung.qlns.model.User;
import com.hung.qlns.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository uRepository;
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public List<User> allUser() {
		return uRepository.findAll();
	}

	public Optional<User> getUser(Long userId) {
		return uRepository.findById(userId);
	}

	public User createUser(UserDTO userInput) {
		User u = new User();
		u.setUserName(userInput.getUserName().trim());
		u.setPassWord(bCryptPasswordEncoder().encode(userInput.getPassWord()));
		uRepository.save(u);
		return u;
	}
	public User updateUser(Long userId, UserDTO userInput) {
		Optional<User> u = uRepository.findById(userId);
		if(u.isPresent()) {
			User nUser = u.get();
			nUser.setUserName(userInput.getUserName().trim());
			nUser.setPassWord(bCryptPasswordEncoder().encode(userInput.getPassWord()));
			uRepository.save(nUser);
			return nUser;
		}else {
			return null;
		}		
	}
	public Boolean deleteUser(Long userId) {
		Optional<User> user = uRepository.findById(userId);
		if(user.isPresent()) {
			User u = user.get();
			uRepository.delete(u);
			return true;
		}else {
			return false;
		}
		
	}
	public boolean isValid(Long userId) {
		Optional<User> u = uRepository.findById(userId);
		return u.isPresent();
	}
	public boolean isValidUserName(String username) {
		User u = uRepository.findByUserName(username);
		return u==null;
	}
	public User findUserByUserName(String username) {
		return uRepository.findByUserName(username);
	}
}