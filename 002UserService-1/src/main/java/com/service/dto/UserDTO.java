package com.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	int userId;
	String userName;
	String email;
	String departmentId;
}
