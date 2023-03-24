package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;
import com.service.dto.ResponseDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;

@RestController 
//@AllArgsConstructor
public class UserController {
	
    @Autowired
	UserService serv;
    
//    this is for testing serverconfigClient
	@Value("${message}")
	String mm;
	
	@GetMapping("/msg")
	public String msg() {
		return mm;
	}
	

	@CircuitBreaker(name="getDepart",fallbackMethod ="getMethod") //here we implimenting resilience 4j Circuit breaker step1
	@GetMapping("/user/{id}")
	public ResponseEntity<ResponseDTO> getUser(@PathVariable Integer id) {
		return new ResponseEntity<ResponseDTO>( serv.getUser(id), HttpStatus.OK);
	}
	
//	step2 both methods return type should be same here we throwing a exception
	public ResponseEntity<ResponseDTO> getMethod(Exception e) {
		return new ResponseEntity("Department server down", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/adduser")
	
	public User addUser(@RequestBody User user) {
		
		serv.addUser(user);
		
		return user;
		
	}
	@DeleteMapping("delete/{id}")
	public ResponseDTO  deleteUser(@PathVariable Integer id) {
		ResponseDTO dto=serv.getUser(id);
		serv.deleteUser(id);
		return dto;
		
		
		
		
	}
	
	
	
}
