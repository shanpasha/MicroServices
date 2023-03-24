package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	String userName;
	@Column(unique = true, nullable = true)
	String email;
	String departmentId;

}
