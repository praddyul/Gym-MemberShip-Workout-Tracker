package com.faangtech.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.faangtech.entity.Trainer;
import com.faangtech.repository.TrainerRepository;
import java.util.List;
	

	@Service
	public class TrainerService {
	    @Autowired
	    private TrainerRepository trainerRepository;

	    public Trainer addTrainer(Trainer trainer) {
	        return trainerRepository.save(trainer);
	    }

	    public Trainer getTrainerById(String trainerId) {
	        return trainerRepository.findById(trainerId).orElse(null);
	    }

	    public List<Trainer> getAllTrainers() {
	        return trainerRepository.findAll();
	    }
	}

