package com.openFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service.dto.DepartmentDTO;


//this is feignClient impl for department Service
@FeignClient(value = "Departments")
public interface FiegnClient {
	
	@GetMapping("/department/{id}")
	public DepartmentDTO getUser(@PathVariable Integer id);
	
	
		
}
