package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Warehouse implements Store {

    private Predicate<Food> filter = f -> getFreshPercent(f) > 75;
    private List<Food> warehouse = new ArrayList<>();

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return warehouse.stream().filter(filter).collect(Collectors.toList());
    }

    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }

        if (accept(food)) {
            return warehouse.add(food);
        }
        return false;
    }

    @Override
    public boolean accept(Food food) {
        return filter.test(food);
    }
    
    public List<Food> getAll() {
        return List.copyOf(warehouse);
    }
}