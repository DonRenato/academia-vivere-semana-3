package com.academiavivere.semana3.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cashbook")
public class CashBook  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_Customer", nullable = false)
    private Customer customer;
    @Column(name = "release_Date", nullable = false)
    private Date releaseDate;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "type", nullable = false)
    private Type type;
    @Column(name = "amount", precision = 12, scale = 2, nullable = false)
    private float amount;


    public int getId() {
        return id;
    }


    @JsonFormat(pattern = "dd/MM/yyyy")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public CashBook(Customer customer, Date releaseDate, String description, Type type, float amount) {
        this.customer = customer;
        this.releaseDate = releaseDate;
        this.description = description;
        this.type = type;
        this.amount = amount;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public CashBook() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



}
