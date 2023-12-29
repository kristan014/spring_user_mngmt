package com.example.user_management.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

    @Column(name = "user_type_id")
    private Long userTypeId;

    @ManyToOne
    @JoinColumn(name = "user_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserType userType;

    public User() {
    }

    public User(
            Long id,
            String username,
            String password,
            Long userTypeId,
            LocalDate created_at,
            LocalDate updated_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userTypeId = userTypeId;
        this.created_at = created_at;
        this.updated_at = updated_at;

    }

    public User(
            String username,
            String password,
            Long userTypeId,
            LocalDate created_at,
            LocalDate updated_at) {
        this.username = username;
        this.password = password;
        this.userTypeId = userTypeId;
        this.created_at = created_at;
        this.updated_at = updated_at;

    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    // public long getUserTypeId() {
    //     return userTypeId;
    // }

    // public void setuserTypeId(Long userTypeId) {
    //     this.userTypeId = userTypeId;
    // }





}

