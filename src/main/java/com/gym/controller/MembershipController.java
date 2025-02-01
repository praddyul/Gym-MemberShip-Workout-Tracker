package com.gym.controller;

import com.gym.membershipEntity.Membership;
import com.gym.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public ResponseEntity<Membership> createMembership(@RequestBody Membership membership) {
        Membership createdMembership = membershipService.createMembership(membership);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMembership);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membership> getMembership(@PathVariable Long id) {
        return membershipService.getMembershipById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


