package ru.job4j.ood.carparking.store;

import ru.job4j.ood.carparking.model.Car;
import ru.job4j.ood.carparking.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ControlParking implements Parking {
    private final List<Vehicle> carList;
    private int passengerPlace;
    private int truckPlace;

    public ControlParking(int passengerPlace, int truckPlace) {
        this.passengerPlace = passengerPlace;
        this.truckPlace = truckPlace;
        carList = new ArrayList<>(passengerPlace + truckPlace);
    }

    public boolean park(Vehicle car) {
        boolean rsl = false;
        int size = car.carSize();
        if (size == Car.CAR_SIZE) {
            if (passengerPlace >= Car.CAR_SIZE) {
                passengerPlace -= size;
                rsl = true;
            }
        } else if (truckPlace != 0) {
            truckPlace--;
            rsl = true;
        } else if (passengerPlace >= size) {
            passengerPlace -= size;
            rsl = true;
        }
        if (rsl) {
            carList.add(car);
        }
        return rsl;
    }

    public List<Vehicle> getCarList() {
        return List.copyOf(carList);
    }
}
