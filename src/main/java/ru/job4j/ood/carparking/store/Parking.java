package ru.job4j.ood.carparking.store;

import ru.job4j.ood.carparking.model.Vehicle;

public interface Parking {
    boolean isFreeSpace(Vehicle car);
    boolean park(Vehicle vehicle);
}
