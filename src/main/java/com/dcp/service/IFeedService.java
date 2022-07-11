
package com.dcp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcp.entity.Feed;

@Service
public interface IFeedService {
	public String addFeed(Feed feed);

	public Feed editComment(int feedId, int totalcomments);

	public List<Feed> likeFeed(int feedId, int relevance);

	public List<Feed> getFeedsByKeyword(String keyword);

	public List<Feed> getFeedsByTopic(String topic);

	public Feed getFeed(int fcode);

	public List<Feed> deleteFeed(int feedId);

}
