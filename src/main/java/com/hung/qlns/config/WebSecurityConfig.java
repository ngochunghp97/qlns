package com.hung.qlns.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hung.qlns.service.MyUserDetailService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//config xac thuc
	@Autowired
	private MyUserDetailService myUser;
	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUser).passwordEncoder(bCryptPasswordEncoder);

	}
//Config loc request
	protected void configure(HttpSecurity http) throws Exception {

		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/signup").permitAll()	
		.antMatchers(HttpMethod.POST, "/api/user").permitAll()
//		.antMatchers(HttpMethod.POST, "/api/employee").hasAnyAuthority()
//		.antMatchers(HttpMethod.POST, "/api/position").hasAnyAuthority()
//		.antMatchers(HttpMethod.POST, "/api/department").hasAnyAuthority()
//		.antMatchers(HttpMethod.PUT, "/api/employee/**").hasAnyAuthority()
//		.antMatchers(HttpMethod.PUT, "/api/position/**").hasAnyAuthority()
//		.antMatchers(HttpMethod.PUT, "/api/department/**").hasAnyAuthority()
//		.antMatchers(HttpMethod.DELETE, "/api/employee/**").hasAnyAuthority()
//		.antMatchers(HttpMethod.DELETE, "/api/position/**").hasRole("USER")
//		.antMatchers(HttpMethod.DELETE, "/api/department/**").hasAnyAuthority()
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/login").failureUrl("/login?error=true")
		.defaultSuccessUrl("/")
		.usernameParameter("username")
		.passwordParameter("password")
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login")
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/access-denied")
		
		//bat khi test do loi method post, put, delete
		.and()
		.csrf().disable();
	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/css/*")
		.antMatchers("/js/*");
	}
}
