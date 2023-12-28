package com.example.user_management.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

    public User() {
    }

    public User(
            Long id,
            String userName,
            String password,
            LocalDate created_at,
            LocalDate updated_at) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;

    }

    public User(
            String userName,
            String password,
            LocalDate created_at,
            LocalDate updated_at) {
        this.userName = userName;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;

    }

    public long getId() {
        return id;
    }

    // public void setId(Long id) {
    //     this.id = id;
    // }
}
