package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.VO.Company;
import com.example.demo.VO.Department;
import com.example.demo.VO.ResponseTemplateVO;
import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service("empserv")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo emprepo;
	
	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return emprepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}

	@Autowired
	RestTemplate resttemp;
	
	
	@Override
	public ResponseTemplateVO getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		
		ResponseTemplateVO vo = new ResponseTemplateVO();
			
		Employee emp = emprepo.findById(id).get();
		ResponseTemplateVO rvo = resttemp.getForObject("http://DEPARTMENT-SERVICE/department/"+emp.getDept_id(), ResponseTemplateVO.class);
		
		Department 	dept = rvo.getDepartment();
		Company comp = resttemp.getForObject("http://COMPANY-SERVICE/company/"+dept.getComp_id(), Company.class);
		
		vo.setEmp(emp);
		vo.setCompany(comp);	
		vo.setDepartment(dept);
		
		return vo;
	}

}
