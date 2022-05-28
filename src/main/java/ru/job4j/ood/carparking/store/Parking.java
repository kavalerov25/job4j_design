package ru.job4j.ood.carparking.store;

import ru.job4j.ood.carparking.model.Vehicle;

public interface Parking {

    boolean parking(Vehicle vehicle, int size);
}
