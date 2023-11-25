package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable=false)
    private String username;
    @Column(nullable=false)
    private String password;
    @Transient
    private int status;
    @Transient
    private String message;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}