package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Warehouse implements Store {

    private Predicate<Food> filter = f -> getFreshPercent(f) > 75;
    private List<Food> foods = new ArrayList<>();

    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }
        boolean rsl = filter.test(food);
        if (rsl) {
            foods.add(food);
        }
        return rsl;
    }

    @Override
    public Predicate<Food> filter() {
        return filter;
    }

    public List<Food> getAll() {
        return List.copyOf(foods);
    }
}