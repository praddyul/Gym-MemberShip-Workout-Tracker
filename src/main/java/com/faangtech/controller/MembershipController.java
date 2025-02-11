package com.faangtech.controller;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import com.faangtech.entity.Membership;
import com.faangtech.service.MembershipService;

import java.util.List;

	@RestController

	public class MembershipController {
	    @Autowired
	    private MembershipService membershipService;

	    @PostMapping("/memberships")
	    public ResponseEntity<Membership> register(@RequestBody Membership membership) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(membershipService.createMembership(membership));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Membership> getMembership(@PathVariable String id) {
	        return ResponseEntity.ok(membershipService.getMembership(id));
	    }

	    @GetMapping
	    public ResponseEntity<List<Membership>> getAllMemberships() {
	        return ResponseEntity.ok(membershipService.getAllMemberships());
	    }
	}


