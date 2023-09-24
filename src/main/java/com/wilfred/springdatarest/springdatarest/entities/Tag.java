package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tag")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tag {

@Id
    private String tag;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

  /*  create table tag
            (
                    id         bigint       not null
                    primary key,
                    tag        varchar(255) null,
    article_id bigint       null,
    constraint FKhutavxkklg0b3kj7rmcnc9hvf
    foreign key (article_id) references article (id)
            );*/

}
