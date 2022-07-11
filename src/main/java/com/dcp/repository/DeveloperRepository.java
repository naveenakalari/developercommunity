package com.dcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcp.entity.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer,Integer>{

	

}

