package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;

public interface Store {

    boolean add(Food food);

    Predicate<Food> filter();

    List<Food> getAll();


    default long getFreshPercent(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }
        long shelfLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpireDate());
        long daysUntilExpiry = ChronoUnit.DAYS.between(LocalDate.now(), food.getExpireDate());
        double percent = (double) daysUntilExpiry / shelfLife * 100;
        return (long) percent;
    }
}