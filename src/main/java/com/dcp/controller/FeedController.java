
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

import com.dcp.entity.Feed;
import com.dcp.exception.FeedNotFoundException;
import com.dcp.serviceImpl.FeedService;

@RestController
public class FeedController {

	@Autowired
	private FeedService feedService;

	@PostMapping("/addFeed")
	public String saveFeed(@Valid @RequestBody Feed feed) {
		return feedService.addFeed(feed);

	}

	@PutMapping("/editComments/{id}/{totalComments}")
	public Feed editComments(@PathVariable("id") int feedId, @PathVariable("totalComments") int totalComments) {
		return feedService.editComment(feedId, totalComments);
	}

	@PutMapping("/likeFeed/{id}/{relevance}")
	public List<Feed> likeFeed(@PathVariable("id") int feedId, @PathVariable("relevance") int relevance)
			throws FeedNotFoundException {
		return feedService.likeFeed(feedId, relevance);
	}

	@PutMapping(value = "/getFeed/{id}")
	public Feed getFeed(@PathVariable("id") int fcode) {
		return feedService.getFeed(fcode);
	}

	@GetMapping("/getByKeyword/{keyword}")
	public List<Feed> getFeedsByKeyword(@PathVariable("keyword") String keyword) {
		return feedService.getFeedsByKeyword(keyword);
	}

	@GetMapping("/getByTopic/{topic}")
	public List<Feed> getFeedsByTopic(@PathVariable("topic") String topic) {
		return feedService.getFeedsByTopic(topic);
	}

}
