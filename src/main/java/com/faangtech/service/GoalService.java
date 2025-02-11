package com.faangtech.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.faangtech.entity.Goal;
import com.faangtech.repository.GoalRepository;
import java.util.Optional;


	@Service
	public class GoalService {
	    @Autowired
	    private GoalRepository goalRepository;

	    public Goal setGoal(Goal goal) {
	        return goalRepository.save(goal);
	    }

	    public Goal getGoalByUserId(String userId) {
	        return goalRepository.findByUserId(userId).orElse(null);
	    }

	    public Goal updateProgress(String userId, String progress) {
	        Optional<Goal> goalOpt = goalRepository.findByUserId(userId);
	        if (goalOpt.isPresent()) {
	            Goal goal = goalOpt.get();
	            goal.setProgress(progress);
	            return goalRepository.save(goal);
	        }
	        return null;
	    }
	}


