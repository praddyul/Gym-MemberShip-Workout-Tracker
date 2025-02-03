package com.faang.bindu.repository;

import com.faang.bindu.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkOutRepo  extends JpaRepository<Workout,Integer> {
    public Optional<Workout> findByMemberId(String memberId);
}
