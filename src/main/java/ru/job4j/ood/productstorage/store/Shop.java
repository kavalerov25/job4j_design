package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ru.job4j.ood.productstorage.store.Discount.DISCOUNT_25;

public class Shop implements Store {
    private List<Food> shop = new LinkedList<>();
    private Predicate<Food> filter = food -> getFreshPercent(food) <= 75 && getFreshPercent(food) > 0;

    @Override
    public List<Food> findBy(Predicate<Food> predicate) {
        return shop.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }

        boolean isOK = accept(food);
        if (isOK) {
            if (getFreshPercent(food) < 25) {
                food.setDiscount(DISCOUNT_25);
            }
            shop.add(food);
        }
        return isOK;
    }

    @Override
    public boolean accept(Food food) {
        return filter.test(food);
    }

    @Override
    public List<Food> getAllFoods() {
        return shop;
    }

    @Override
    public List<Food> clear() {
        List<Food> retList = this.shop;
        this.shop = new LinkedList<>();
        return retList;
    }
}
