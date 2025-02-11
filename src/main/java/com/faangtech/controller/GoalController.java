package com.faangtech.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.faangtech.entity.Goal;
import com.faangtech.service.GoalService;

	
	@RestController
	public class GoalController {
	    @Autowired
	    private GoalService goalService;

	    @PostMapping("/goals")
	    public ResponseEntity<Goal> setGoal(@RequestBody Goal goal) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(goalService.setGoal(goal));
	    }

	    @GetMapping("/{userId}")
	    public ResponseEntity<Goal> getGoal(@PathVariable String userId) {
	        Goal goal = goalService.getGoalByUserId(userId);
	        if (goal != null) {
	            return ResponseEntity.ok(goal);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PatchMapping("/{userId}")
	    public ResponseEntity<Goal> updateProgress(@PathVariable String userId, @RequestBody String progress) {
	        Goal updatedGoal = goalService.updateProgress(userId, progress);
	        if (updatedGoal != null) {
	            return ResponseEntity.ok(updatedGoal);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}


