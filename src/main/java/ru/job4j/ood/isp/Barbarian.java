package ru.job4j.ood.isp;


/**
 * Класс Barbarian реализует все методы представленные интерфейсом Action.
 * Класс Barbarian не может реализовать метод magic(), так как варвары не умеют колдовать.
 */
public class Barbarian implements Action {
    @Override
    public void go() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void magic() {
        throw new UnsupportedOperationException();
    }
}
