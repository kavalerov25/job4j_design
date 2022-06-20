package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Warehouse implements Store {

    private Predicate<Food> filter = f -> getFreshPercent(f) > 75;
    private List<Food> warehouseStorage = new LinkedList<>();

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return warehouseStorage.stream().filter(filter).collect(Collectors.toList());
    }

    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }

        boolean isOK = accept(food);
        if (isOK) {
            warehouseStorage.add(food);
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
        return List.copyOf(warehouseStorage);
    }

    @Override
    public List<Food> clear() {
        List<Food> retList = getAllFoods();
        warehouseStorage.removeAll(retList);
        return retList;
    }
}