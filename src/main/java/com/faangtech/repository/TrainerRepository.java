package com.faangtech.repository;
import com.faangtech.entity.Trainer;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;


	public interface TrainerRepository extends MongoRepository<Trainer, String> {
	}


