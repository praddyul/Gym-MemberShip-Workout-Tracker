package com.faang.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.faang.controller.TrainerController;
import com.faang.entity.Trainer;
import com.faang.service.TrainerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TrainerController.class)
public class TrainerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrainerService trainerService; 
    
    @Test
    public void testAssignTrainer() throws Exception {
        Trainer savedTrainer = new Trainer("trainer1", "user1");
        savedTrainer.setId(1); 
        
        // Mock the service call 
        when(trainerService.assignTrainer(any(Trainer.class))).thenReturn(savedTrainer);

        mockMvc.perform(post("/assignTrainer")  
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"trainerId\":\"trainer1\",\"userId\":\"user1\"}"))
                .andExpect(status().isCreated()) // Expect HTTP status 201 Created
                .andExpect(jsonPath("$.trainerId").value("trainer1"))  // Validate response trainerId
                .andExpect(jsonPath("$.userId").value("user1"))  // Validate response userId
                .andExpect(jsonPath("$.id").value(1));  // Validate response ID
    }

    
    @Test
    public void testGetAllTrainers() throws Exception {
        // Create a list of sample trainers
        Trainer trainer1 = new Trainer("trainer1", "user1");
        trainer1.setId(1);
        Trainer trainer2 = new Trainer("trainer2", "user2");
        trainer2.setId(2);
        List<Trainer> trainers = Arrays.asList(trainer1, trainer2);

        // Mock the service 
        when(trainerService.getAllTrainers()).thenReturn(trainers);

        mockMvc.perform(get("/getAllTrainers"))  
                .andExpect(status().isOk())  // Expect HTTP status 200 OK
                .andExpect(jsonPath("$.length()").value(2))  // Check that the list has 2 trainers
                .andExpect(jsonPath("$[0].trainerId").value("trainer1"))  // Check trainer1 trainerId
                .andExpect(jsonPath("$[1].trainerId").value("trainer2"));  // Check trainer2 trainerId
    }
}
