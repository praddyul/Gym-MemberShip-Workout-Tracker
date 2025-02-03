package com.faang.bindu.service;

import com.faang.bindu.entity.Workout;
import com.faang.bindu.entity.WorkoutProgress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkOutService {
      public String insertData(Workout workout);
      public WorkoutProgress getProgress(String memberId);
      public List<Workout> fetchHistory(int id);
}