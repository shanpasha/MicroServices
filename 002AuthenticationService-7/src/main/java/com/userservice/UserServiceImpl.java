package com.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.User;
import com.userRepo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	 @Autowired
  private UserRepository userRepository;
 
 
  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }
  @Override
  public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
    User user = userRepository.findByUsernameAndPassword(name, password);
    if(user == null){
       throw new UserNotFoundException("Invalid id and password");
    }
    return user;
  }
}