package com.userservice;

import com.user.User;

public interface UserService {
    public void saveUser(User user);
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}