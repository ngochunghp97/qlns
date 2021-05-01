package com.hung.qlns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hung.qlns.model.User;
import com.hung.qlns.service.DepartmentService;
import com.hung.qlns.service.EmployeeService;
import com.hung.qlns.service.PositionService;
import com.hung.qlns.service.UserService;

@Controller
public class WebController {
	
	@Autowired
	private EmployeeService emService;
	@Autowired
	private DepartmentService deService;
	@Autowired
	private PositionService poService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/employee")
	public String employee(Model model) {
		model.addAttribute("emList", emService.allEmployee());
		return "employee";
	}
	@GetMapping("/position")
	public String position(Model model) {
		model.addAttribute("poList", poService.allPosition());
		return "position";
	}
	@GetMapping("/department")
	public String department(Model model) {
		model.addAttribute("deList", deService.allDepartments());
		return "department";
	}
	@GetMapping("/department/create")
	public String createDepartment() {
		return "validate-form-department";
	}
	@GetMapping("/employee/create")
	public String createEmployee() {
		return "validate-form-employee";
	}
	
	@GetMapping("/position/create")
	public String createPosition() {
		return "validate-form-position";
	}
	

	@GetMapping("/signup")
	public String signupGet() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signupPost(@RequestParam("username") String username, @RequestParam("password") String password) {
		User u = new User();
		u.setUserName(username);
		u.setPassWord(password);
		userService.createUser(u);
		return "redirect:/login";
	}


}
