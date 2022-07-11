
package com.dcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dcp.entity.Feed;
import com.dcp.serviceImpl.FeedService;

@RestController
public class AdminFeedController {

	@Autowired
	private FeedService feedService;

	@DeleteMapping("/deleteFeed/{id}")
	public List<Feed> deleteFeed(@PathVariable("id") int feedId) {
		return feedService.deleteFeed(feedId);
	}

}
