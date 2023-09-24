package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="STORIES")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Story extends Task {
    @Column(name ="SPRINT_ID")
    private Long sprintId;

    Story(String name, String author, Long sprintId) {
        super(name, author);
        this.sprintId = sprintId;
    }
}
