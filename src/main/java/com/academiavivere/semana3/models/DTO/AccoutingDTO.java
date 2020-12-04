package com.academiavivere.semana3.models.DTO;

import java.util.ArrayList;
import java.util.List;

public class AccoutingDTO {
    private int id;
    private String name;
    private String cpfCnpj;
    private String phone;

    private  List<CashBookDTO> accouting = new ArrayList();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getPhone() {
        return phone;
    }

    public List<CashBookDTO> getAccouting() {
        return accouting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccouting(List<CashBookDTO> accouting) {
        this.accouting = accouting;
    }

    public void setId(int id) {
        this.id = id;
    }
}
