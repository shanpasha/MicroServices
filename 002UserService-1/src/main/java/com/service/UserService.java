package com.service;

import com.entity.User;
import com.service.dto.ResponseDTO;

public interface UserService{

	
	public ResponseDTO getUser(Integer id);
	public void addUser(User user);
	public void deleteUser(Integer uId);
	
	
}
