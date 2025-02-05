package com.faang.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainers")
public class Trainer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Trainer() {
		
	}
 public Trainer(String trainerId, String userId) {
		
		this.trainerId = trainerId;
		this.userId = userId;
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private String trainerId;
    private String userId;
}

