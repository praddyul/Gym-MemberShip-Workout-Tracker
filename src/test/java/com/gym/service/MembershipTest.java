package com.gym.service;

import com.gym.membershipEntity.Membership;
import com.gym.repository.MembershipRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MembershipTest {

    @Mock
    private MembershipRepo membershipRepository;

    @InjectMocks
    private MembershipService membershipService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateMembership() {
        Membership membership = new Membership();
        membership.setUserId("AK01");
        membership.setMembershipType("Premium");
        membership.setStartDate(LocalDate.of(2025, 2, 1));

        Membership savedMembership = new Membership();
        savedMembership.setMembershipId(1L);
        savedMembership.setUserId("AK01");
        savedMembership.setMembershipType("Premium");
        savedMembership.setStartDate(LocalDate.of(2025, 2, 1));
        savedMembership.setEndDate(LocalDate.of(2026, 2, 1));

        when(membershipRepository.save(any(Membership.class))).thenReturn(savedMembership);

        Membership result = membershipService.createMembership(membership);

        assertNotNull(result);
        assertEquals(1L, result.getMembershipId());
        assertEquals("AK01", result.getUserId());
        assertEquals("Premium", result.getMembershipType());
        assertEquals(LocalDate.of(2025, 2, 1), result.getStartDate());
        assertEquals(LocalDate.of(2026, 2, 1), result.getEndDate());

        verify(membershipRepository, times(1)).save(any(Membership.class));
    }

    @Test
    public void testGetMembership() {
        Membership membership = new Membership();
        membership.setMembershipId(1L);
        membership.setUserId("AK01");
        membership.setMembershipType("Premium");
        membership.setStartDate(LocalDate.of(2025, 2, 1));
        membership.setEndDate(LocalDate.of(2026, 2, 1));

        when(membershipRepository.findById(1L)).thenReturn(java.util.Optional.of(membership));

        Membership result = membershipService.getMembershipById(1L).orElseThrow(() ->
                new RuntimeException("Membership not found"));

        assertNotNull(result);
        assertEquals(1L, result.getMembershipId());
        assertEquals("AK01", result.getUserId());
        assertEquals("Premium", result.getMembershipType());
        assertEquals(LocalDate.of(2025, 2, 1), result.getStartDate());
        assertEquals(LocalDate.of(2026, 2, 1), result.getEndDate());

        verify(membershipRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetMembership_NotFound() {
        when(membershipRepository.findById(1L)).thenReturn(java.util.Optional.empty());
        assertThrows(RuntimeException.class, () ->
                membershipService.getMembershipById(1L).orElseThrow(() ->
                        new RuntimeException("Membership not found")));

        verify(membershipRepository, times(1)).findById(1L);
    }
}
