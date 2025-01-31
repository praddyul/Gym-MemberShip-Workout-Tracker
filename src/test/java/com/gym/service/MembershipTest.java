package com.gym.service;

import com.gym.membershipEntity.Membership;
import com.gym.repository.MembershipRepo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MembershipTest {

    MembershipRepo repo= mock(MembershipRepo.class);
    MembershipService service=new MembershipService(repo);

    @Test
    public void testCreateMemberShip(){
        Membership membership=new Membership();
        membership.setUserId("Ak01");
        membership.setMembershipType("Gold");
        membership.setStartDate(LocalDate.now());

        when(repo.save(any(Membership.class))).thenReturn(membership);
        Membership savedMembership=service.createMembership(membership);

        assertNotNull(savedMembership);
        assertEquals("Ak01",savedMembership.getUserId());
    }

    public void testGetMemberShipById(){
        Membership membership=new Membership();
        membership.setMembershipId(07L);
        when(repo.findById(07L)).thenReturn(Optional.of(membership));

        Optional<Membership> foundMembership=service.getMembershipById(07L);
        assertTrue(foundMembership.isPresent());
        assertEquals(07L,foundMembership.get().getMembershipId());
    }
}
