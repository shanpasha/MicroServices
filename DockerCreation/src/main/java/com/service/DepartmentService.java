package com.service;

import java.util.List;

import com.entity.Department;


public interface DepartmentService {
	
	
	public void addDepart(Department department);
	public List<Department> getAllDepartment();
	public Department getDepartment(Integer dId);
	public void updateDepart(Department department);
	public void deleteDepart(Integer id);
	
	

}
