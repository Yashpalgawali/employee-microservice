package com.example.demo.VO;


import com.example.demo.models.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO
{
		private Department department;
		
		private Company company;
		private Employee emp;
		
}