package com.example.MainApp.entity;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	private Integer id;
	private String  name;
	private String email;
	private String password;
	private String loc;

}
