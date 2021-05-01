package com.hung.qlns.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hung.qlns.model.User;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserService uService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = uService.findUserByUserName(username);
		if(user!=null) {
			Set<String> roles = new HashSet<>();
			roles.add("USER");
			List<GrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
			return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassWord(),authorities);
		}else return null;
		
	}
}
