package com.academiavivere.semana3.models;

public enum Profile {
    A("A"), O("O");

    private final String description;

    Profile(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return this.description;
    }
}
