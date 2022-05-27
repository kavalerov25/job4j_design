package ru.job4j.ood.productstorage.model;

import java.time.LocalDate;

public class Spagetti extends Food {
    public Spagetti(String name, LocalDate createDate, LocalDate expireDate, double price, double discount) {
        super(name, createDate, expireDate, price, discount);
    }
}
