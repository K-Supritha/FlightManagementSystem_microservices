package com.capg.fms.us.controller;



import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.us.dto.Users;
import com.capg.fms.us.exception.UserAccountNotFoundException;
import com.capg.fms.us.service.UsersService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UsersController 
{
	@Autowired
	private UsersService usersService;
	public void setUserService(UsersService usersService)
	{
		this.usersService=usersService;
	}
	@GetMapping(value="/login/{username}/{password}",produces="application/json")   
	public ResponseEntity<Optional<Users>> checkUser(@PathVariable String username,@PathVariable String password) throws UserAccountNotFoundException
	{    
		Optional<Users> user = usersService.getUser(username);
		if(user.isPresent() && user.get().getPassword().equals(password)) 
			return new ResponseEntity<Optional<Users>>(user,HttpStatus.OK);
		return new ResponseEntity<Optional<Users>>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<String> registerUser(@Valid @RequestBody Users user)
	{
		String message="{\"status\":\"success\"}";
		   if(usersService.addUser(user)==null) {
			   message="{\"status\":\"error\"}";
			   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		   }
		   return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}