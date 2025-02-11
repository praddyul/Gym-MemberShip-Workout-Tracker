package com.faangtech.repository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.faangtech.entity.Goal;
import java.util.Optional;

	public interface GoalRepository extends MongoRepository<Goal, String> {
	    Optional<Goal> findByUserId(String userId);
	}


