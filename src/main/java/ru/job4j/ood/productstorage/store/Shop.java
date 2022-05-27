package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Store {
    private List<Food> foods = new ArrayList<>();
    private Predicate<Food> filter = food -> getFreshPercent(food) <= 75 && getFreshPercent(food) > 0;

    @Override
    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }
        boolean rsl = filter.test(food);
        if (rsl) {
            if (getFreshPercent(food) < 25) {
                food.setDiscount(75);
            }
            foods.add(food);
        }
        return rsl;
    }

    @Override
    public Predicate<Food> filter() {
        return filter;
    }

    @Override
    public List<Food> getAll() {
        return List.copyOf(foods);
    }
}
