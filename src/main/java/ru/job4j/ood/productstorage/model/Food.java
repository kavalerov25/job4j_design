package ru.job4j.ood.productstorage.model;

import java.time.LocalDate;

public class Food {
    private String name;
    private LocalDate expireDate;
    private LocalDate createDate;
    private double price;
    private double discount;

    public Food(String name, LocalDate createDate, LocalDate expireDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("Food{name='%s', expireDate=%s, createDate=%s, price=%s, discount=%s}", name, expireDate, createDate, price, discount);
    }
}
