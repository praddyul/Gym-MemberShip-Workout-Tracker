package com.faangtech.repository;
import com.faangtech.entity.Membership;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MembershipRepository extends MongoRepository<Membership, String> {

}
