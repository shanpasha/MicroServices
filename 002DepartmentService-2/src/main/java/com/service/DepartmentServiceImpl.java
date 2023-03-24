package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.DepartmentRepository;
import com.entity.Department;
import com.exception.DepartmentException;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepository repo;
	

	@Override
	public void addDepart(Department department) {
		repo.save(department);
		
	}

	@Override
	public List<Department> getAllDepartment() {
		
		return repo.findAll();
	}

	@Override
	public void updateDepart(Department department) {
   repo.findById(department.getDepartmentId())
			.orElseThrow(()-> new DepartmentException("records not found..!", "DATA NOT FOUND"));
		
	repo.save(department);
	
	
	}

	@Override
	public void deleteDepart(Integer id) {
		
	repo.findById(id)
				.orElseThrow(()-> new DepartmentException("records not found..!", "ID NOT FOUND"));
			
		repo.deleteById(id);
	}

	@Override
	public Department getDepartment(Integer dId) {
		Department dept=repo.findById(dId)
				.orElseThrow(()-> new DepartmentException("records not found..!", "ID NOT FOUND")); 
		return dept;
	}

}
