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
        Workout workout=repo.findByMemberId(memberId).get();
        WorkoutProgress w1=new WorkoutProgress(workout.getUserId(), workout.getProgress()+" kg loss");
        return w1;
    }

    @Override
    public List<Workout> fetchHistory(int memberId){
        return repo.findAll().stream().filter(workout -> workout.getMemberId().equals(memberId)).toList();
    }
}
