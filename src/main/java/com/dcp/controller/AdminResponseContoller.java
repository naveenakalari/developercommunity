
package com.dcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dcp.entity.Response;
import com.dcp.serviceImpl.ResponseService;

@RestController
public class AdminResponseContoller {

	@Autowired
	private ResponseService responseService;

	@DeleteMapping("/deleteResponse/{id}")
	public List<Response> deleteResponse(@PathVariable("id") int respId) {
		return responseService.deleteResponse(respId);
	}

}
