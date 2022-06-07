package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ru.job4j.ood.productstorage.ControlQuality.DISCOUNT;

public class Shop implements Store {
    private List<Food> shop = new ArrayList<>();
    private Predicate<Food> filter = food -> getFreshPercent(food) <= 75 && getFreshPercent(food) > 0;

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return shop.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }

        if (accept(food)) {
            return shop.add(food);
        }
        return false;
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = filter.test(food);
        if (rsl) {
            return true;
        } else if (getFreshPercent(food) < 25) {
            food.setDiscount(DISCOUNT);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> getAll() {
        return List.copyOf(shop);
    }
}
