package ru.job4j.ood.carparking.model;

public class Car extends Vehicle {
    public static final int CAR_SIZE = 1;

    public Car(int size) {
        super(size);
    }

    public int getCarSize() {
        return CAR_SIZE;
    }
}
