package ru.job4j.ood.productstorage.store;

import ru.job4j.ood.productstorage.model.Food;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ru.job4j.ood.productstorage.store.Discount.DISCOUNT_25;

public class Shop implements Store {
    private List<Food> shopStorage = new LinkedList<>();
    private Predicate<Food> filter = food -> getFreshPercent(food) <= 75 && getFreshPercent(food) > 0;

    @Override
    public List<Food> findBy(Predicate<Food> predicate) {
        return shopStorage.stream().filter(predicate).collect(Collectors.toList());
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
            shopStorage.add(food);
        }
        return isOK;
    }

    @Override
    public boolean accept(Food food) {
        return filter.test(food);
    }

    @Override
    public List<Food> getAllFoods() {
        return List.copyOf(shopStorage);
    }

    @Override
    public List<Food> clear() {
        List<Food> retList = getAllFoods();
        shopStorage.removeAll(retList);
        return retList;
    }
}
