package com.example.demo.service;

import java.util.List;

import com.example.demo.VO.ResponseTemplateVO;
import com.example.demo.models.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp);
	
	public List<Employee> getAllEmployees();
	
	public ResponseTemplateVO getEmployeeById(Long id);
}
