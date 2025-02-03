package com.faang.bindu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;


@Entity
@Table
public class Workout {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            Integer id;
    @Column
    String userId;
    @Column
    String memberId;
    @Column
    String exercise;
    @Column
     int sets;
    @Column
     int reps;
    @Column
    int duration;
  //  Instant duration = Instant.now();
    @Column
      @JsonIgnore
    Double progress;

    public Workout(Integer id, String userId, String memberId, String exercise, int sets, int reps, int duration, Double progress) {
        this.id = id;
        this.userId = userId;
        this.memberId = memberId;
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
        this.progress = progress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }
}
