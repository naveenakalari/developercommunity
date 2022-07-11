package com.dcp.service;

import java.util.List;

import com.dcp.entity.Developer;

public interface IDeveloperService {

	public String addDeveloper(Developer dev) ;
	public List<Developer> getAllDeveloper() ;
	public List<Developer> editFeeds(int dcode,int totalFeeds);
	public Developer getById(int devId);
	public String updateStatus(int dcode,String skillLevel);
}
