package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Trash implements Store {
    private Predicate<Food> filter = f -> getFreshPercent(f) <= 0;
    private List<Food> trashStorage = new LinkedList<>();

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return trashStorage.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }
        boolean isOK = accept(food);
        if (isOK) {
            trashStorage.add(food);
        }
        return isOK;
    }

    @Override
    public boolean accept(Food food) {
        return filter.test(food);
    }

    @Override
    public List<Food> getAllFoods() {
        return List.copyOf(trashStorage);
    }

    @Override
    public List<Food> clear() {
        List<Food> retList = getAllFoods();
        trashStorage.removeAll(retList);
        return retList;
    }
}