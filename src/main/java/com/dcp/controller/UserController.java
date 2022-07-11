package com.dcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dcp.entity.User;
import com.dcp.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	
	@DeleteMapping("/removeUser/{id}")
	public List<User> removeUser(@PathVariable("id") int id){
		 return userService.removeUser(id);
	}
    @GetMapping("/SignOut/{message}")
    public String SignOut(@PathVariable("message")String message) {
    	return userService.SignOut(message);
    }
}
