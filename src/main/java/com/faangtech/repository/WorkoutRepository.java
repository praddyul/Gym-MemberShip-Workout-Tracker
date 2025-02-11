package com.faangtech.repository;
import com.faangtech.entity.Workout;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


	public interface WorkoutRepository extends MongoRepository<Workout, String> {
	    List<Workout> findByUserId(String userId);
	}

