package com.faang.bindu.service;

import com.faang.bindu.entity.Workout;
import com.faang.bindu.entity.WorkoutProgress;
import com.faang.bindu.repository.WorkOutRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
public class WorkOutServiceImpl implements WorkOutService {
    @Autowired
    WorkOutRepo repo;
    @Override
    public String insertData(Workout workout){
        Double pr=(workout.getReps()+ workout.getSets())*0.1;
        workout.setProgress(pr);
        repo.save(workout);
        return "Record inserteted "+workout.getUserId();

    }
    @Override
    public WorkoutProgress getProgress(String memberId){
        List<Workout> workout1=repo.findAll().stream().filter(workout -> workout.getMemberId().equals(memberId)).toList();
        double sum=0.0;
        for (Workout w:workout1){
            sum+=w.getProgress();
        }
        WorkoutProgress w1=new WorkoutProgress(workout1.get(0).getUserId(), sum+" kg loss");
        return w1;
    }

    @Override
    public List<Workout> fetchHistory(int memberId){
        return repo.findAll().stream().filter(workout -> workout.getUserId().equals(userId)).toList();
    }
}
