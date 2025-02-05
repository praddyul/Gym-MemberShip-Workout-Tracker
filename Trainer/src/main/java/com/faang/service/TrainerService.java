package com.faang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faang.entity.Trainer;
import com.faang.repository.TrainerRepository;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer assignTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
    
    public List<Trainer> getAllTrainers()
    {
    	return trainerRepository.findAll();
    }
}
