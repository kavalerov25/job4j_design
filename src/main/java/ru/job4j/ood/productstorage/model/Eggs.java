package ru.job4j.ood.productstorage.model;

import java.time.LocalDate;

public class Eggs extends Food {
    public Eggs(String name, LocalDate expireDate, LocalDate createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
