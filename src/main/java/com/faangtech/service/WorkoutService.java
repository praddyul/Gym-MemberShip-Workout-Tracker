package com.faangtech.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.faangtech.entity.Workout;
import com.faangtech.repository.WorkoutRepository;
import java.util.List;


	@Service
	public class WorkoutService {
	    @Autowired
	    private WorkoutRepository workoutRepository;

	    public Workout logWorkout(Workout workout) {
	        return workoutRepository.save(workout);
	    }

	    public List<Workout> getUserWorkouts(String userId) {
	        return workoutRepository.findByUserId(userId);
	    }
	}

