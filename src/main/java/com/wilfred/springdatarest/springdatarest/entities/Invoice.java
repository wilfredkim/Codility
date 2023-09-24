package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity()
@Table(name ="DOCUMENTS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Invoice extends Document{
    @Column(name ="PAY_DATE")
    private LocalDate paymentDate;

    Invoice(String referenceId, String authorName, LocalDate paymentDate) {
        super(referenceId, authorName, "INV");
        this.paymentDate = paymentDate;
    }
}