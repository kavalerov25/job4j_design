package ru.job4j.ood.carparking.store;

import ru.job4j.ood.carparking.model.Vehicle;

public class TruckParking implements Parking {

    @Override
    public boolean parking(Vehicle vehicle, int size) {
        return false;
    }
}
