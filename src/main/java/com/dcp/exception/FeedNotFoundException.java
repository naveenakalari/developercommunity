package com.dcp.exception;

public class FeedNotFoundException extends RuntimeException {
	public String toString() {
		return "Feed not found";
	}

}
