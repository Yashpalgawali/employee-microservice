package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "tbl_employee")
public class Employee {
	
	@Id
	@SequenceGenerator(allocationSize = 1,initialValue = 1,name = "emp_seq")
	@GeneratedValue(generator = "emp_seq" , strategy = GenerationType.AUTO)
	private Long emp_id;
	
	private String emp_name;
	
	private Long dept_id;

}
