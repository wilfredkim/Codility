package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@MappedSuperclass
@Table(name = "DOCUMENTS")
public class Document {
    @Id
    @GeneratedValue
    @Column(name ="DOC_ID")
    private Long id;
    @Column(name ="REFERENCE_ID")
    private String referenceId;
    @Column(name ="AUTHOR_NAME")
    private String authorName;
    @Column(name ="DOC_TYPE")
    private String documentType;

    Document(String referenceId, String authorName, String documentType) {
        this.referenceId = referenceId;
        this.authorName = authorName;
        this.documentType =  documentType;
    }

    public String getAuthorName() {
        return authorName;
    }
}
