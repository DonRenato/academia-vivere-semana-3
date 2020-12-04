package com.academiavivere.semana3.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "customers")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "cpfCnpj", nullable = false, length = 14, unique = true)
    private String cpfCnpj;
    @Column(name = "address", nullable = false, length = 50)
    private String address;
    @Column(name = "phone", length = 11)
    private String phone;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "city", nullable = false, length = 40)
    private String city;
    @Column(name = "state", nullable = false, length = 2)
    private String state;
    @Column(name = "CEP", nullable = false, length = 8)
    private String CEP;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCEP() {
        return CEP;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Customer(String name, String cpfCnpj, String address, String phone, String email, String city, String state, String CEP, Date createdAt) {
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.state = state;
        this.CEP = CEP;
        this.createdAt = createdAt;
    }

    public Customer(String name, String cpfCnpj, String address, String city, String state, String CEP, Date createdAt) {
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.address = address;
        this.city = city;
        this.state = state;
        this.CEP = CEP;
        this.createdAt = createdAt;
    }

    public boolean validadeCpfCnpj(String cpfCnpj){
        String regex = "[0-9]+";
        return this.cpfCnpj.matches(regex);
    }

    public Customer() {
    }
}
