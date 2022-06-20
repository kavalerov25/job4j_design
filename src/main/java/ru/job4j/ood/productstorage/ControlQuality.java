package ru.job4j.ood.productstorage;

import ru.job4j.ood.productstorage.model.Food;
import ru.job4j.ood.productstorage.store.Store;

import java.util.LinkedList;
import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void sort(List<Food> foodList) {
        for (Food food : foodList) {
            for (Store store : stores) {
                if (store.accept(food)) {
                    store.add(food);
                    break;
                }
            }
        }
    }

    /**
     * Соберем всю еду в один список и потом повторно проидемся с этим списком по хранилищам
     * правда это увеличит сложность до квадратичной
     */
    public void resort() {
        List<Food> foodList = new LinkedList<>();
        for (Store store : stores) {
            foodList.addAll(store.clear());

        }
        sort(foodList);
    }
}


