package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.VO.ResponseTemplateVO;
import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empserv;
	
	@PostMapping("/")
	public String saveEmployee(@RequestBody Employee emp)
	{
		if(empserv.saveEmployee(emp)!=null)
		{
			return "redirect:/";
		}
		else {
			return "Employee Not saved";
		}
	}
	
	@GetMapping("/")@ResponseBody
	public List<Employee> getAllEmployees()
	{
		return empserv.getAllEmployees();
	}
	
	@GetMapping("/{id}")@ResponseBody
	public ResponseTemplateVO getEmployeeById(@PathVariable("id") Long id)
	{
		return empserv.getEmployeeById(id);
	}
}
