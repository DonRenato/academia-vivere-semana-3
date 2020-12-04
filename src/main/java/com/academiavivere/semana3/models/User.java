package com.academiavivere.semana3.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "users",
        uniqueConstraints = @UniqueConstraint( columnNames = "login"))
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "login", unique = true, nullable = false, length = 15)
    private String login;
    @Column(name = "password", nullable = false, length = 10)
    private String password;
    @Column(name = "phone", length = 11)
    private String phone;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "profile", nullable = false, length = 1)
    private Profile profile;
    @Column(name = "status", nullable = false, length = 1)
    private Status status;
    @Column(name = "created_at", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Profile getProfile() {
        return profile;
    }

    public Status getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User(String name, String login, String password, String phone, String email, Profile profile, Status status, Date createdAt) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.profile = profile;
        this.status = status;
        this.createdAt = createdAt;
    }

    public User(String name, String login, String password, Profile profile, Status status, Date createdAt) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.profile = profile;
        this.status = status;
        this.createdAt = createdAt;
    }

    public User() {
    }

    }
