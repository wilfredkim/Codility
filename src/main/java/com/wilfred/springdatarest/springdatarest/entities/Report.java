package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity()
@Table(name ="DOCUMENTS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Report extends Document{
    @Column(name = "BEGIN")
    private LocalDate startDate;
    @Column(name =  "FINISH")
    private LocalDate endDate;

    Report(String referenceId, String authorName, LocalDate startDate, LocalDate endDate) {
        super(referenceId, authorName, "REP");
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
