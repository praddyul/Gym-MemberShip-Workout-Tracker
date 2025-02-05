import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.faang.controller.TrainerController;
import com.faang.entity.Trainer;
import com.faang.service.TrainerService;

@WebMvcTest(TrainerController.class)
public class TrainerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrainerService trainerService;

    // Test POST /trainers
    @Test
    public void testCreateTrainer() throws Exception {
       
        Trainer savedTrainer = new Trainer("trainer1", "user1");
        savedTrainer.setId(1); 

        // Mock the service call
        when(trainerService.assignTrainer(any(Trainer.class))).thenReturn(savedTrainer);

        // Perform POST request to /trainers
        mockMvc.perform(post("/trainers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"trainerId\":\"trainer1\",\"userId\":\"user1\"}"))
                .andExpect(status().isCreated())  // Expect 201 Created
                .andExpect(jsonPath("$.trainerId").value("trainer1"))  // Check trainerId in the response
                .andExpect(jsonPath("$.userId").value("user1"))  // Check userId in the response
                .andExpect(jsonPath("$.id").value(1L));  // Check if ID is returned
    }

    // Test GET /trainers
    @Test
    public void testGetAllTrainers() throws Exception {
        // Sample trainers to be returned by the mock service
        Trainer trainer1 = new Trainer("trainer1", "user1");
        trainer1.setId(1);
        Trainer trainer2 = new Trainer("trainer2", "user2");
        trainer2.setId(2);
        List<Trainer> trainers = Arrays.asList(trainer1, trainer2);

        // Mock the service call 
        when(trainerService.getAllTrainers()).thenReturn(trainers);

        // Perform GET request to /trainers
        mockMvc.perform(get("/trainers"))
                .andExpect(status().isOk())  
                .andExpect(jsonPath("$.length()").value(2))  e
                .andExpect(jsonPath("$[0].trainerId").value("trainer1"))  
                .andExpect(jsonPath("$[1].trainerId").value("trainer2"));  
    }
}