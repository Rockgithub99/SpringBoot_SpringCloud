package com.example.MainApp.service;

import java.util.List;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MainApp.entity.User;

@FeignClient(value="cl",url="localhost:9000")
public interface UserCilentProxy {
	
	@GetMapping("/getUser")
	public User getUser();
	
	@GetMapping("/getAll")
	public List<User> getAllUser();
	
	@GetMapping("/getfind/{id}")
	public Optional<User> getFindUser(@PathVariable Integer id);
	
	@PostMapping("/postfind")
	public User createUser(@RequestBody User user) ;
	
	
	@PutMapping("/putfind/{id}")
	public User updateFindUser(@PathVariable Integer id ,@RequestBody User user) ;
	


	@DeleteMapping("/deletefind/{id}")
	public Integer deletFindUser(@PathVariable Integer  id) ;
	

	@PostMapping("/postUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) ;
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user);

}
