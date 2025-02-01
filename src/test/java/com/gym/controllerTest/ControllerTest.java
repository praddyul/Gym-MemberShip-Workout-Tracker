package com.gym.controllerTest;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 import com.gym.controller.MembershipController;
 import com.gym.membershipEntity.Membership;
 import com.gym.service.MembershipService;
 import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Optional;


@WebMvcTest(MembershipController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MembershipService membershipService;

    @Test
    public void testCreateMembership() throws Exception {
        Membership savedMembership = new Membership();
        savedMembership.setMembershipId(1L);
        savedMembership.setUserId("AK01");
        savedMembership.setMembershipType("Premium");
        savedMembership.setStartDate(LocalDate.of(2025, 2, 1));
        savedMembership.setEndDate(LocalDate.of(2026, 2, 1));

        when(membershipService.createMembership(any(Membership.class))).thenReturn(savedMembership);

        mockMvc.perform(post("/memberships")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":\"AK01\",\"membershipType\":\"Premium\",\"startDate\":\"2025-02-01\"}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.membershipId").value(1L));
    }

    @Test
    public void testGetMembership() throws Exception {
        Membership membership = new Membership();
        membership.setMembershipId(1L);
        membership.setUserId("AK01");
        membership.setMembershipType("Premium");
        membership.setStartDate(LocalDate.of(2025, 2, 1));
        membership.setEndDate(LocalDate.of(2026, 2, 1));

        when(membershipService.getMembershipById(1L)).thenReturn(Optional.of(membership));

        mockMvc.perform(get("/memberships/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.membershipId").value(1L));
    }
}
