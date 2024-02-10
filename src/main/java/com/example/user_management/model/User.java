package com.example.user_management.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import com.example.user_management.enums.Role;


@Entity
@Table(name = "users")
public class User implements UserDetails{

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
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
            LocalDate updated_at,
            Role role
            ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userTypeId = userTypeId;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.role = role;
    }

    public User(
            String username,
            String password,
            Long userTypeId,
            LocalDate created_at,
            LocalDate updated_at,
            Role role) {
        this.username = username;
        this.password = password;
        this.userTypeId = userTypeId;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.role = role;

    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    @Override
    public String getPassword() {
        return password;
    }

    public void setId(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public String getUsername() {
        return username;
    }

    

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // public long getUserTypeId() {
    //     return userTypeId;
    // }

    // public void setuserTypeId(Long userTypeId) {
    //     this.userTypeId = userTypeId;
    // }





}

