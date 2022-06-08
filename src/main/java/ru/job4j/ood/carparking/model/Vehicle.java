package ru.job4j.ood.carparking.model;

public abstract class Vehicle {
    private int size;

    public Vehicle(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}