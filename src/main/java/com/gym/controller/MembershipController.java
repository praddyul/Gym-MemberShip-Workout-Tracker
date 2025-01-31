package com.gym.controller;

import com.gym.membershipEntity.Membership;
import com.gym.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    private final MembershipService service;

    public MembershipController(MembershipService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Membership> createMembership(@RequestBody Membership membership){
        return ResponseEntity.status(201).body(service.createMembership(membership));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membership>  getMembership(@PathVariable Long id){
        Optional<Membership> membership=service.getMembershipById(id);
        return membership.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Membership>> getAllMemberships(){
        return ResponseEntity.ok(service.getAllMemberships());
    }
}
