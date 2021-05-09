package com.hung.qlns.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hung.qlns.model.Department;
import com.hung.qlns.model.Position;
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
		model.addAttribute("emList", emService.getEmAll());
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
	@GetMapping("/assign-position")
	public String assignPosition() {
		return "assign-position";
	}
	@GetMapping("/assign-department")
	public String assignDepartment() {
		return "assign-department";
	}
	@GetMapping("/employee-detail/{id}")
	public String employeeDetail(@PathVariable("id") Long emId, Model model) {
		model.addAttribute("emDetailList", emService.getEmployeeDetail(emId));
		return "employee-detail";
	}
	@GetMapping("/employee-update/{id}")
	public String employeeUpdate(@PathVariable("id") Long emId, Model model) {
		model.addAttribute("emDetailList", emService.getEmployeeDetail(emId));
		return "update-form-employee";
	}
	@GetMapping("/position-detail/{id}")
	public String positionDetail(@PathVariable("id") Long posId, Model model) {
		Optional<Position> po = poService.getPosition(posId);
		Position p = po.get();
		model.addAttribute("posDetailList", p);
		return "position-detail";
	}
	@GetMapping("/position-update/{id}")
	public String positionUpdate(@PathVariable("id") Long posId, Model model) {
		Optional<Position> po = poService.getPosition(posId);
		Position p = po.get();
		model.addAttribute("posDetailList", p);
		return "update-form-position";
	}
	@GetMapping("/department-detail/{id}")
	public String departmentDetail(@PathVariable("id") Long deId, Model model) {
		Optional<Department> de = deService.getDepartment(deId);
		Department d = de.get();
		model.addAttribute("deDetailList", d);
		return "department-detail";
	}
	@GetMapping("/department-update/{id}")
	public String departmentUpdate(@PathVariable("id") Long deId, Model model) {
		Optional<Department> de = deService.getDepartment(deId);
		Department d = de.get();
		model.addAttribute("deDetailList", d);
		return "update-form-department";
	}
}
