package ru.job4j.ood.productstorage;

import ru.job4j.ood.productstorage.model.Food;
import ru.job4j.ood.productstorage.store.Store;

import java.util.List;

public class ControlQuality {

    public static final int DISCOUNT = 20;
    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void sort(List<Food> foodList) {
        for (Food food : foodList) {
            for (Store store : stores) {
                if (store.accept(food)) {
                    store.add(food);
                }
            }
        }
    }
}
