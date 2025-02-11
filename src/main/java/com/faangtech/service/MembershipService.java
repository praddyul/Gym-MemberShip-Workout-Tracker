package com.faangtech.service;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import com.faangtech.entity.Membership;
	import com.faangtech.repository.MembershipRepository;
    import java.util.List;
	
	@Service
	public class MembershipService {
	    @Autowired
	    private MembershipRepository membershipRepository;

	    public Membership createMembership(Membership membership) {
	        return membershipRepository.save(membership);
	    }

	    public Membership getMembership(String id) {
	        return membershipRepository.findById(id).orElse(null);
	    }

	    public List<Membership> getAllMemberships() {
	        return membershipRepository.findAll();
	    }
	}


