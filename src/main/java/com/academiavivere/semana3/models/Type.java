package com.academiavivere.semana3.models;

public enum Type {
    C("C"), D("D");

    private final String description;

    Type(String description) {
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
