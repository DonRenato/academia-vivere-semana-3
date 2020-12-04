package com.academiavivere.semana3.models;

public enum Status {
    A("A"), C("C");

    private final String description;

    Status(String description) {
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
