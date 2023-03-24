package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Department;
import com.service.DepartmentService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
@Slf4j
public class DepartController {
	
	
	private DepartmentService service;
	
	@PostMapping
	public ResponseEntity<Department> AddDepartment(@RequestBody Department department){
		service.addDepart(department);
		return new ResponseEntity<Department>(department, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable("id") Integer id){
		
		log.info("getting Department BY ID*****",id);
		
		Department dept=service.getDepartment(id);
		
		return new ResponseEntity<Department>(dept,HttpStatus.OK);
		
		
	}
	
	
	
	
	

}
