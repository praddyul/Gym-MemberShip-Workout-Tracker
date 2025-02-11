package com.faangtech.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "trainers")
public class Trainer {
    @Id
    private String trainerId;
    private String name;
    private String specialization;

    // Constructors
    public Trainer() {}

    public Trainer(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Getters and Setters
    public String getTrainerId() { return trainerId; }
    public void setTrainerId(String trainerId) { this.trainerId = trainerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
}



