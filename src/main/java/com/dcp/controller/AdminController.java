
package com.dcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcp.entity.User;
import com.dcp.exception.UserNotFoundException;
import com.dcp.service.IDeveloperService;
import com.dcp.service.IFeedService;
import com.dcp.service.IResponseService;
import com.dcp.service.IUserService;

@RestController
public class AdminController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IDeveloperService developerService;

	@Autowired
	private IFeedService feedService;

	@Autowired
	private IResponseService responseService;

	@PutMapping("/updateUser/{id}/{password}")
	public List<User> updatePassword(@PathVariable("id") int id, @PathVariable("password") String password)
			throws UserNotFoundException {
		return userService.updatePassword(id, password);
	}
}
