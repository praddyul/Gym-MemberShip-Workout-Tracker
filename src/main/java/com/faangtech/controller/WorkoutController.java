package com.faangtech.controller;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import com.faangtech.entity.Workout;
import com.faangtech.service.WorkoutService;

import java.util.List;

	@RestController
	public class WorkoutController {
	    @Autowired
	    private WorkoutService workoutService;

	    @PostMapping("/workouts")
	    public ResponseEntity<Workout> logWorkout(@RequestBody Workout workout) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(workoutService.logWorkout(workout));
	    }

	    @GetMapping("?userId=user1")
	    public ResponseEntity<List<Workout>> getWorkouts(@PathVariable String userId) {
	        return ResponseEntity.ok(workoutService.getUserWorkouts(userId));
	    }
	}


