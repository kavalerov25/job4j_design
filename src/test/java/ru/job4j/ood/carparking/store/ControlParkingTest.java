package ru.job4j.ood.carparking.store;

import org.junit.Test;
import ru.job4j.ood.carparking.model.Car;
import ru.job4j.ood.carparking.model.Truck;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControlParkingTest {
    @Test
    public void whenTwoPassengerAndOneTruckPlacesThanTwoTrucks() {
        var parking = new ControlParking(2, 1);
        var truck = new Truck(2);
        assertTrue(parking.park(truck));
        assertTrue(parking.park(truck));
        assertFalse(parking.park(truck));
    }

    @Test
    public void whenTwoPassengerAndOneTruckPlacesThanOneCarAndTwoTrucks() {
        var parking = new ControlParking(2, 1);
        var car = new Car();
        var truck = new Truck(2);
        assertTrue(parking.park(car));
        assertTrue(parking.park(truck));
        assertFalse(parking.park(truck));
        assertTrue(parking.park(car));
        assertFalse(parking.park(car));
    }

    @Test
    public void whenTwoPassengerAndNoTruckPlacesThanOneTruckAndNoCar() {
        var parking = new ControlParking(2, 0);
        var car = new Car();
        var truck = new Truck(2);
        assertTrue(parking.park(truck));
        assertFalse(parking.park(car));
        assertFalse(parking.park(truck));
    }

    @Test
    public void whenNoPassengerAndOneTruckPlacesThanNoCar() {
        var parking = new ControlParking(0, 1);
        var car = new Car();
        assertFalse(parking.park(car));
    }
}