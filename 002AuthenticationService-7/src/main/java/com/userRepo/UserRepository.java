package com.userRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
public User findByUsernameAndPassword(String userName, String password);
}