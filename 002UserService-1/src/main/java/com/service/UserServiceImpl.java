package com.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dao.UserRepository;
import com.entity.User;
import com.exceptions.UserException;
import com.openFeignClient.FiegnClient;
import com.service.dto.DepartmentDTO;
import com.service.dto.ResponseDTO;
import com.service.dto.UserDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private UserRepository urepo;
	
	//private RestTemplate template;
	private FiegnClient fiegn;
	
//	private WebClient webclient;
	
	
	
	@Override
	public ResponseDTO getUser(Integer id) {
		//Data transfering to user to UserDTO
		UserDTO user= mapToUser(urepo.findById(id)
				.orElseThrow(()-> new UserException("No records Found in this ID", "ID NOT FOUND")));
				
//		By using Reclient
//		String getUrl="http://departments/department/"+user.getDepartmentId();
//		ResponseEntity<DepartmentDTO> responseEntity=template.getForEntity(getUrl, DepartmentDTO.class);
//		DepartmentDTO deptDto=responseEntity.getBody();
		
		//----By using WebClient
		
//		DepartmentDTO deptDto=webclient.get()
//				.uri("http://localhost:52916/department/"+user.getDepartmentId())
//				.retrieve().bodyToMono(DepartmentDTO.class).block();
		
		
		
//		By using FiegnClient
		DepartmentDTO deptDto=fiegn.getUser(id);
	
		
		
		
		ResponseDTO response=new ResponseDTO();
		
		response.setDepartment(deptDto);
		response.setUser(user);
		
		return response;
	}
//Data transferring to user to UserDTO
	private UserDTO mapToUser(User user) {
		
		UserDTO userdto=new UserDTO();	
		userdto.setUserId(user.getUserId());
		userdto.setUserName(user.getUserName());
		userdto.setDepartmentId(user.getDepartmentId());
		userdto.setEmail(user.getEmail());
		
		
		return userdto;
	}

	@Override
	public void addUser(User user) {
		System.out.println("hello");
		if(!urepo.existsById(user.getUserId())) {
			System.out.println(urepo.save(user));
			
			
		}
		
		
	}
	@Override
	public void deleteUser(Integer uId) {
		
		if(!urepo.existsById(uId)) {
			throw new UserException("given Id not Found", "ID NOT FOUND");
			
		}
		urepo.deleteById(uId);
		
	}
	
	
	

}
