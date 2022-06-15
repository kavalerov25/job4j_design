package ru.job4j.ood.carparking.model;

public class Car implements Vehicle {
    public static final int CAR_SIZE = 1;

    @Override
    public int carSize() {
        return CAR_SIZE;
    }
}
