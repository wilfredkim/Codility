package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "article")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Tag> tags = new ArrayList<>();
}

       /* create table article
        (
        id      bigint       not null
        primary key,
        content varchar(255) null,
        title   varchar(255) null
        );*/
