package com.gym.service;

import com.gym.membershipEntity.Membership;
import com.gym.repository.MembershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipService {

    @Autowired
    private final MembershipRepo repo;

    public MembershipService(MembershipRepo repo) {
        this.repo=repo;
    }

    public Membership createMembership(Membership membership){
        membership.setEndDate(membership.getStartDate().plusYears(1));
        return repo.save(membership);
    }

    public Optional<Membership> getMembershipById(Long id){
        return repo.findById(id);
    }

    public List<Membership> getAllMemberships(){
        return repo.findAll();
    }
}
