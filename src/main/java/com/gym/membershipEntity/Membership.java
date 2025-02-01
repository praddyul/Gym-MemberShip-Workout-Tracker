package com.gym.membershipEntity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
@Data
public class Membership {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        private Long membershipId;

        @Column
        private String userId;

        @Column
         private String membershipType;

        @Column
        private LocalDate startDate;

        @Column
        private LocalDate endDate;




}
