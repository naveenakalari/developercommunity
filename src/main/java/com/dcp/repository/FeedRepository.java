
package com.dcp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.dcp.entity.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Integer> {

	@Query("select f from Feed f where f.query like %:keyword% ")
	List<Feed> findByKeyword(@Param("keyword") String key);

	List<Feed> findByTopic(String topic);

	
}
