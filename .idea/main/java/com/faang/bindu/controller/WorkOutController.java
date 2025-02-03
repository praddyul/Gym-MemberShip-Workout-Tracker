package com.faang.bindu.controller;

import com.faang.bindu.entity.Workout;
import com.faang.bindu.entity.WorkoutProgress;
import com.faang.bindu.service.WorkOutService;
import com.faang.bindu.service.WorkOutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkOutController {
    @Autowired
    Environment environment;

    @Autowired
    WorkOutService ser;

    @PostMapping(value="/insert")
    public String addRecord(@RequestBody Workout workout){
        System.out.println("workout :"+workout.getUserId());
      // System.out.println(environment.getProperty("test.name"));
       return ser.insertData(workout);
    }

    @GetMapping("/goals/{memberId}")
    public WorkoutProgress getProgress(@PathVariable String memberId){
        return ser.getProgress(memberId);
    }

    @GetMapping("/fetch/{memberId}")
    public List<Workout> fetchHistory(@PathVariable int memberId){
        return ser.fetchHistory(memberId);
    }
}
