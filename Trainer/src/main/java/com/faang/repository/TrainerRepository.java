package com.faang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faang.entity.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
}
