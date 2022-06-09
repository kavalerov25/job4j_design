package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Trash implements Store {
    private Predicate<Food> filter = f -> getFreshPercent(f) <= 0;
    private List<Food> trash = new ArrayList<>();

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return trash.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }
        boolean isOK = accept(food);
        if (isOK) {
             trash.add(food);
        }
        return isOK;
    }

    @Override
    public boolean accept(Food food) {
        return filter.test(food);
    }

    @Override
    public List<Food> getAll() {
        return List.copyOf(trash);
    }
}