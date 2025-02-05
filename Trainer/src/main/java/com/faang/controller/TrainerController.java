package com.faang.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.faang.entity.Trainer;
import com.faang.service.TrainerService;

@RestController
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/assignTrainer")
    public ResponseEntity<Trainer> assignTrainer(@RequestBody Trainer trainer) {
        Trainer assignedTrainer = trainerService.assignTrainer(trainer);
        return new ResponseEntity<>(assignedTrainer, HttpStatus.CREATED);
    }
    
    @GetMapping("/getAllTrainers")
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        return new ResponseEntity<>(trainers, HttpStatus.OK);  // Return all trainers with status 200 OK
    }
}