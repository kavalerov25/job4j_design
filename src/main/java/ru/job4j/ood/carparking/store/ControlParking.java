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

    @Override
    public boolean isFreeSpace(Vehicle car) {
        boolean rsl = false;
        int size = car.carSize();
        if (size == Car.CAR_SIZE && passengerPlace >= Car.CAR_SIZE) {
            rsl = true;
            passengerPlace -= size;
        } else if (size > Car.CAR_SIZE && truckPlace != 0) {
            truckPlace--;
            rsl = true;
        } else if (size > Car.CAR_SIZE && passengerPlace >= size) {
            passengerPlace -= size;
            rsl = true;
        }
        return rsl;
    }

    public boolean park(Vehicle car) {
        boolean rsl = isFreeSpace(car);
        if (rsl) {
            carList.add(car);
        }
        return rsl;
    }

    public List<Vehicle> getCarList() {
        return List.copyOf(carList);
    }
}
