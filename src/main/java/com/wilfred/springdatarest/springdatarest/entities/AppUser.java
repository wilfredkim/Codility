package com.wilfred.springdatarest.springdatarest.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="USERS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name ="PERSON_ID")
    private Long id;


    @Column(name ="LOGIN")
    private String login;
    @Column(name ="USER_NAME")
    private String firstName;
    @Column(name ="USER_SURNAME")
    private String lastName;

    AppUser(Long sessionId, String login, String firstName, String lastName) {

        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getLogin() {
        return login;
    }
}
