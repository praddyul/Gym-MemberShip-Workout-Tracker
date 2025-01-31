package com.gym.membershipEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    public Membership() {
    }

    public Membership(String userId, String membershipType, LocalDate startDate, LocalDate endDate) {
        this.userId = userId;
        this.membershipType = membershipType;
        this.startDate = startDate;
        this.endDate = endDate;
    }


}
