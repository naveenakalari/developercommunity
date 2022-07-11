
package com.dcp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcp.entity.Response;
import com.dcp.service.IResponseService;

@RestController
public class ResponseController {

	@Autowired
	private IResponseService rservice;

	@PostMapping("/addResponse")
	public String addResponse(@Valid @RequestBody Response response) {
		return rservice.addResponse(response);
	}

	
	  @PutMapping("/editAnswer/{id}/{answer}") public Response
	  editAnswer(@PathVariable("id") int respId, @PathVariable("answer") String
	  answer) {
	  
	  return rservice.editAnswer(respId, answer); }
	  
	  @PutMapping("/likeResponse/{id}/{accuracy}") public List<Response>
	  likeResponse(@PathVariable("id") int respId, @PathVariable("accuracy") int
	  accuracy) { return rservice.likeResponse(respId, accuracy); }
	  
	
	  
	
	 @GetMapping("/getResponseByDevId/{id}") 
	 public List<Response>getResponseByDev(@PathVariable("id") int devId) { 
		 return rservice.getResponseByDev(devId); }
}
