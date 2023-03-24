package com.jwtgen;

import java.util.Map;

import com.user.User;

public interface JwtGeneratorInterface {
Map<String, String> generateToken(User user);
}