package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Task {
    @Column(name = "TASK_ID")
    @Id
    @GeneratedValue
    private Long id;
    @Column(name ="NAME")
    private String name;
    @Column(name ="AUTHOR")
    private String author;

    Task(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }
}
