package com.faangtech.entity;


	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;

	@Document(collection = "goals")
	public class Goal {
	    @Id
	    private String goalId;
	    private String userId;
	    private String goal;
	    private String progress; // Example: "1kg lost so far"

	    // Constructors
	   

	    public Goal(String userId, String goal, String progress) {
	        this.userId = userId;
	        this.goal = goal;
	        this.progress = progress;
	    }

	    // Getters and Setters
	    public String getGoalId() { return goalId; }
	    public void setGoalId(String goalId) { this.goalId = goalId; }

	    public String getUserId() { return userId; }
	    public void setUserId(String userId) { this.userId = userId; }

	    public String getGoal() { return goal; }
	    public void setGoal(String goal) { this.goal = goal; }

	    public String getProgress() { return progress; }
	    public void setProgress(String progress) { this.progress = progress; }
	}

