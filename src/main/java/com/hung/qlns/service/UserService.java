package com.hung.qlns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hung.qlns.model.User;
import com.hung.qlns.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository uRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<User> allUser() {
		return uRepository.findAll();
	}

	public Optional<User> getUser(Long userId) {
		return uRepository.findById(userId);
	}

	public User createUser(User user) {
		User u = new User();
		u.setUserName(user.getUserName().trim());
		u.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
		uRepository.save(u);
		return u;
	}
	public User updateUser(Long userId, User user) {
		Optional<User> u = uRepository.findById(userId);
		User nUser = u.get();
		nUser.setUserName(user.getUserName().trim());
		nUser.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
		uRepository.save(nUser);
		return nUser;
	}
	public Long deleteUser(Long userId) {
		uRepository.deleteById(userId);
		return userId;
	}
	public boolean isValid(Long userId) {
		Optional<User> u = uRepository.findById(userId);
		return u.isPresent();
	}
	public boolean isValidUserName(String userName) {
		User u = uRepository.findByUserName(userName);
		return u==null;
	}
	public User findUserByUserName(String username) {
		return uRepository.findByUserName(username);
	}
}
