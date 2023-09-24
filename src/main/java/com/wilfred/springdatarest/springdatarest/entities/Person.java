package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="PERSONS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Person {
    @Id
    @GeneratedValue
    @Column(name ="PERSON_ID")
    private Long id;

    @Column(name ="SESSION_ID")
    private Long sessionId;

    protected Person(Long sessionId) {
        this.sessionId = sessionId;
    }
}
