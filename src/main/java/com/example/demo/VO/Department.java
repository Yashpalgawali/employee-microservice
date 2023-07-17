package com.example.demo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	private Long dept_id;
	
	private String dept_name;
	
	private Long comp_id;
	
}