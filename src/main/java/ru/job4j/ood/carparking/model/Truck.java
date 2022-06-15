package ru.job4j.ood.carparking.model;

public class Truck implements Vehicle {
    private int size;

    public Truck(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Это не грузовой автомобиль");
        }
        this.size = size;
    }

    @Override
    public int carSize() {
        return size;
    }
}