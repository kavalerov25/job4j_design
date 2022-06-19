package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Warehouse implements Store {

    private Predicate<Food> filter = f -> getFreshPercent(f) > 75;
    private List<Food> warehouse = new LinkedList<>();

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return warehouse.stream().filter(filter).collect(Collectors.toList());
    }

    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }

        boolean isOK = accept(food);
        if (isOK) {
            warehouse.add(food);
        }
        return isOK;
    }

    @Override
    public boolean accept(Food food) {
        return filter.test(food);
    }

    /**
     * возвращает копию, чтобы нельзя было изменить напрямую
     */
    public List<Food> getAllFoods() {
        return warehouse;
    }

    @Override
    public List<Food> clear() {
        List<Food> retList = this.warehouse;
        this.warehouse = new LinkedList<>();
        return retList;
    }
}