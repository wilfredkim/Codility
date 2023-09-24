package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "EPICS")
@Entity
public class Epic extends Task {
    @Column(name ="PROJECT_ID")
    private Long projectId;
    @Column(name ="PRODUCT_OWNER_NAME")
    private String productOwner;

    Epic(String name, String author, Long projectId, String productOwner) {
        super(name, author);
        this.projectId = projectId;
        this.productOwner = productOwner;
    }
}
