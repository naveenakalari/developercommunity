
package com.dcp.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "feed")
public class Feed{

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedId;

	@Column(name = "query")
	private String query;

	@Column(name = "date")
	private LocalDate feedDate;

	@Column(name = "time")
	private LocalTime feedTime;

	@Column(name = "topic")
	private String topic;

	@Column(name = "relevance")

	@Min(value = 1)

	@Max(value = 10)
	private int relevance;

	@Column(name = "totalComments")
	private int totalComments;

	
	
	
	  @OneToMany(cascade = CascadeType.ALL) 
	  private List<Response> responses;
	 
	public Feed() {	}

	public Feed(int feedId, String query, LocalDate feedDate, LocalTime feedTime, String topic,
			@Min(1) @Max(10) int relevance, int totalComments, List<Response> responses) {
		super();
		this.feedId = feedId;
		this.query = query;
		this.feedDate = feedDate;
		this.feedTime = feedTime;
		this.topic = topic;
		this.relevance = relevance;
		this.totalComments = totalComments;
		this.responses = responses;
	}

	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public LocalDate getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(LocalDate feedDate) {
		this.feedDate = feedDate;
	}

	public LocalTime getFeedTime() {
		return feedTime;
	}

	public void setFeedTime(LocalTime feedTime) {
		this.feedTime = feedTime;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getRelevance() {
		return relevance;
	}

	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}

	public int getTotalComments() {
		return totalComments;
	}

	public void setTotalComments(int totalComments) {
		this.totalComments = totalComments;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	@Override
	public String toString() {
		return "Feed [feedId=" + feedId + ", query=" + query + ", feedDate=" + feedDate + ", feedTime=" + feedTime
				+ ", topic=" + topic + ", relevance=" + relevance + ", totalComments=" + totalComments + ", responses="
				+ responses + "]";
	}

	
	
}
