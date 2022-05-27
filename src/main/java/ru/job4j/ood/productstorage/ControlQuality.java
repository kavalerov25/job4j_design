package ru.job4j.ood.productstorage;

import ru.job4j.ood.productstorage.model.Food;
import ru.job4j.ood.productstorage.store.Store;
import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void sort(List<Food> foods) {
        for (Store store : stores) {
            foods.forEach(store::add);
        }
    }
}
