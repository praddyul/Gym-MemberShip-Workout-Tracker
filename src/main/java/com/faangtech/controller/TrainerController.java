package com.faangtech.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.faangtech.entity.Trainer;
import com.faangtech.service.TrainerService;
import java.util.List;

	@RestController
	
	public class TrainerController {
	    @Autowired
	    private TrainerService trainerService;

	    @PostMapping("/trainers")
	    public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(trainerService.addTrainer(trainer));
	    }

	    @GetMapping("/{trainerId}")
	    public ResponseEntity<Trainer> getTrainer(@PathVariable String trainerId) {
	        Trainer trainer = trainerService.getTrainerById(trainerId);
	        if (trainer != null) {
	            return ResponseEntity.ok(trainer);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	   /* @GetMapping
	    public ResponseEntity<List<Trainer>> getAllTrainers() {
	        return ResponseEntity.ok(trainerService.getAllTrainers());*/
	    }



