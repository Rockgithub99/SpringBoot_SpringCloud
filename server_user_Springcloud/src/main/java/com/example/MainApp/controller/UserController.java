package com.example.MainApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MainApp.Repo.UserRepo;
import com.example.MainApp.entity.User;

@RestController
//@RequestMapping("/server")

public class UserController {
	
	@Autowired
	private  UserRepo  userRepo;
	
	@GetMapping("/getUser")
	public User getUser() {
	User user= new User(12,"Avi","avinash.g98@xyz.com","12345","Pune");
		
		return user;
		
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUser(){
		List<User> user=(List<User>) userRepo.findAll();
		return user;
		
		
	}
	
	
	@GetMapping("/getfind/{id}")
	public Optional<User> getFindUser(@PathVariable Integer id){
	Optional<User> us1=userRepo.findById(id);
		return us1;
		
	}
	
	@PostMapping("/postfind")
	public User createUser(@RequestBody User user) {
		User out=userRepo.save(user);
		return out;
		
	}
	
	
	@PutMapping("/putfind/{id}")
	public User updateFindUser(@PathVariable Integer id ,@RequestBody User user) {
	Optional<User> res=userRepo.findById(user.getId());
	User use= res.get();
	use.setName(user.getName());
	use.setEmail(user.getEmail());
	use.setPassword(user.getLoc());
	
	User out=userRepo.save(use);

		return out;
		
	}


	@DeleteMapping("/deletefind/{id}")
	public Integer deletFindUser(@PathVariable Integer  id) {
	userRepo.deleteById(id);
		
		return id;
		
	}

	
	@PostMapping("/postUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User out=userRepo.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
		
	}
	


	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User mb = userRepo.save(user);
		return new ResponseEntity<>(mb, HttpStatus.OK);
	}
}
