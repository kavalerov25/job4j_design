package ru.job4j.ood.carparking.store;

import ru.job4j.ood.carparking.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ControlParking implements Parking {
    private int passengerPlace;
    private int truckPlace;
    private List<Vehicle> carList;

    public ControlParking(int passengerPlace, int truckPlace) {
        this.passengerPlace = passengerPlace;
        this.truckPlace = truckPlace;
    }

    public boolean park(Vehicle car) {
        return false;
    }

    public List<Vehicle> getCarList() {
        return List.copyOf(carList);
    }
}
