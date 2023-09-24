package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "GUESTS")
@Entity
public class Guest  {
    @Id
    @GeneratedValue
    @Column(name ="PERSON_ID")
    private Long id;

    // @OneToOne
    // @JoinColumn(name = "PERSON_ID", referencedColumnName ="PERSON_ID")
    // private Person person;

    @Column(name ="TEMPORARY_NAME")
    private String tempName;

    Guest(Long sessionId, String tempName) {
        // super(sessionId);
        this.tempName = tempName;
    }

    public String getTempName() {
        return tempName;
    }
}
