
  package com.dcp.repository;
  
  import java.util.List;
  
  import org.springframework.data.jpa.repository.JpaRepository; 
  import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dcp.entity.Response;
  
  public interface ResponseRepository extends JpaRepository<Response,Integer>{
  
     @Query("select r from Response r where r.dev.devId=:id ") 
	 List<Response> findByDev(@Param("id") int devId);
  

  
  
  }
 