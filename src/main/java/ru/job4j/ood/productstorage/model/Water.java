package ru.job4j.ood.productstorage.model;

import java.time.LocalDate;

public class Water extends Food {
    public Water(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
