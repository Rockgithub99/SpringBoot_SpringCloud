package com.example.MainApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.MainApp.entity.User;
import com.example.MainApp.service.UserCilentProxy;

@RestController
@RequestMapping("/client")
public class UserClientController {
	
	@Autowired
	private UserCilentProxy clientProxy;

	
	@GetMapping("/getClient")
	public User getUser() {
		User result = clientProxy.getUser();
		return new User(result.getId(), result.getName(), result.getEmail(), result.getPassword(), result.getLoc());

	}
	
	
	@GetMapping("/getClientUser")
	public List<User> getAllClientUser(){
		List<User> res=clientProxy.getAllUser();
		List<User>  out= new ArrayList<>();
		out.addAll(res);
		return out;
		
	}
	
	@GetMapping("/getfindClient/{id}")
	public Optional<User> getFindById(@PathVariable Integer id) {
		Optional<User> us=clientProxy.getFindUser(id);
		return us;
		
	}
	
	@PostMapping("/postClient")
	public User createClientUser(@RequestBody User user) {
	  User var=	clientProxy.createUser(user);
		return var;
		
	}
	
	
	@PutMapping("/putClient/{id}")
	public User updateClient(@PathVariable Integer id, @RequestBody User user) {
	User var2=clientProxy.updateFindUser(id, user);
		
		return var2; 
		
	}
	
	
	@DeleteMapping("/deleteClient/{id}")
	public Integer deleteClientById(@PathVariable Integer id) {
		Integer user=clientProxy.deletFindUser(id);
		return user;
		
	}
	
	@PostMapping("/postUpdate")
	public ResponseEntity<User> saveClientUser(@RequestBody User user) {
		ResponseEntity<User> temp=clientProxy.saveUser(user);
		return new ResponseEntity(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/putSave")
	public ResponseEntity<User> updateRetriveUser(@RequestBody User user) {
		ResponseEntity<User> on=clientProxy.updateUser(user);
		return new ResponseEntity<User>(HttpStatus.OK);
		
	}
	
	

}
