package com.faangtech.entity;


	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;
	import java.util.Date;

	@Document(collection = "workouts")
	public class Workout {
	    @Id
	    private String id;
	    private String userId;
	    private String exercise;
	    private int sets;
	    private int reps;
	    private int duration; // in minutes
	    private Date date;
	    
	    
		public Workout(String id, String userId, String exercise, int sets, int reps, int duration, Date date) {
			super();
			this.id = id;
			this.userId = userId;
			this.exercise = exercise;
			this.sets = sets;
			this.reps = reps;
			this.duration = duration;
			this.date = date;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getExercise() {
			return exercise;
		}
		public void setExercise(String exercise) {
			this.exercise = exercise;
		}
		public int getSets() {
			return sets;
		}
		public void setSets(int sets) {
			this.sets = sets;
		}
		public int getReps() {
			return reps;
		}
		public void setReps(int reps) {
			this.reps = reps;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}

	    // Constructors, Getters, Setters
	}


