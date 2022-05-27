package ru.job4j.ood.productstorage;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.ood.productstorage.model.Bread;
import ru.job4j.ood.productstorage.model.Eggs;
import ru.job4j.ood.productstorage.model.Food;
import ru.job4j.ood.productstorage.model.Milk;
import ru.job4j.ood.productstorage.store.Shop;
import ru.job4j.ood.productstorage.store.Store;
import ru.job4j.ood.productstorage.store.Trash;
import ru.job4j.ood.productstorage.store.Warehouse;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {
    Shop shop;
    Trash trash;
    Warehouse warehouse;
    List<Store> stores;
    ControlQuality controlQuality;

    @Before
    public void date() {
        shop = new Shop();
        trash = new Trash();
        warehouse = new Warehouse();
        stores = List.of(warehouse, shop, trash);
        controlQuality = new ControlQuality(stores);
    }

    @Test
    public void whenExpired() {
        Food milk = new Milk("Petmol",
                LocalDate.of(2022, 4, 1),
                LocalDate.of(2022, 4, 25),
                100,
                0);
        List<Food> foods = List.of(milk);
        controlQuality.sort(foods);
        assertThat(trash.getAll(), is(foods));
    }

    @Test
    public void whenExpiryDateLessThen25AndSetDiscount() {
        Food eggs = new Eggs("Eggs Sinyavino",
                LocalDate.of(2022, 4, 30),
                LocalDate.of(2022, 5, 30),
                100,
                0);
        List<Food> foods = List.of(eggs);
        controlQuality.sort(foods);
        assertThat(eggs.getDiscount(), is(75.0));
    }

    @Test
    public void whenExpiryDateHiThen75() {
        Food bread = new Bread("Bread",
                LocalDate.of(2022, 5, 27),
                LocalDate.of(2023, 6, 27),
                70.1,
                0);
        List<Food> foods = List.of(bread);
        controlQuality.sort(foods);
        assertThat(warehouse.getAll(), is(foods));
        assertThat(bread.getDiscount(), is(0.0));
    }

    @Test
    public void whenMultiSort() {
        Food eggs = new Eggs("Eggs",
                LocalDate.of(2022, 4, 1),
                LocalDate.of(2022, 4, 25),
                100,
                0);
        Food bread = new Bread("Bread",
                LocalDate.of(2022, 4, 30),
                LocalDate.of(2022, 6, 30),
                200, 0);
        Food milk = new Milk("Milk",
                LocalDate.of(2022, 4, 30),
                LocalDate.of(2022, 6, 30),
                200, 0);
        Food spagetti = new Food("Spagetti",
                LocalDate.of(2022, 5, 27),
                LocalDate.of(2023, 5, 27),
                150.1, 0);
        List<Food> foods = List.of(eggs, bread, spagetti, milk);
        controlQuality.sort(foods);
        assertThat(trash.getAll(), is(List.of(eggs)));
        assertThat(shop.getAll(), is(List.of(bread, milk)));
        assertThat(warehouse.getAll(), is(List.of(spagetti)));
    }


    @Test(expected = IllegalArgumentException.class)
    public void whenAddToWHNullThenIllegalArgumentsThenException() {
        Store warehouse = new Warehouse();
        warehouse.add(null);
    }
}