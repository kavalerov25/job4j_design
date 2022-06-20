package ru.job4j.ood.productstorage;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.ood.productstorage.model.*;
import ru.job4j.ood.productstorage.store.Shop;
import ru.job4j.ood.productstorage.store.Store;
import ru.job4j.ood.productstorage.store.Trash;
import ru.job4j.ood.productstorage.store.Warehouse;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
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
        assertThat(trash.getAllFoods(), is(foods));
    }

    @Test
    public void whenExpiryDateLessThen25AndSetDiscount() {

        LocalDate created = LocalDate.now().plusDays(1);
        LocalDate expired = LocalDate.now().plusMonths(20);

        Food eggs = new Eggs("Eggs Sinyavino",
                created,
                expired,
                150,
                20);
        List<Food> foods = List.of(eggs);
        controlQuality.sort(foods);
        assertThat(eggs.getDiscount(), is(20.0));
    }

    @Test
    public void whenExpiryDateHiThen75() {
        Food bread = new Bread("Bread",
                LocalDate.now().minusDays(80),
                LocalDate.now().plusDays(20),
                70.1,
                0);
        List<Food> foods = List.of(bread);
        controlQuality.sort(foods);
        assertThat(shop.getAllFoods(), is(foods));
        assertThat(bread.getDiscount(), is(25.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddToWHNullThenIllegalArgumentsThenException() {
        Store warehouse = new Warehouse();
        warehouse.add(null);
    }

    @Test
    public void whenMultiSort() {
        Food eggs = new Eggs("Eggs",
                LocalDate.of(2022, 4, 1),
                LocalDate.of(2022, 4, 25),
                100,
                0);
        Food bread = new Bread("Bread",
                LocalDate.now().minusDays(80),
                LocalDate.now().plusDays(20),
                200, 0);
        Food milk = new Milk("Milk",
                LocalDate.now().minusDays(80),
                LocalDate.now().plusDays(20),
                200, 0);
        Food spagetti = new Food("Spagetti",
                LocalDate.now().minusDays(80),
                LocalDate.now().plusYears(2),
                150.1, 0);
        List<Food> foods = List.of(eggs, bread, spagetti, milk);
        controlQuality.sort(foods);
        assertThat(trash.getAllFoods(), is(List.of(eggs)));
        assertThat(shop.getAllFoods(), is(List.of(bread, milk)));
        assertThat(warehouse.getAllFoods(), is(List.of(spagetti)));
    }

    @Test
    public void whenResort() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate expiryDate = LocalDate.now().minusDays(10);
        LocalDate createDate = LocalDate.now().minusDays(100);
        Food milk = new Milk("Milk", expiryDate, createDate, 59.0, 0.0);
        warehouse.add(milk);
        assertThat(warehouse.getAllFoods(), is(List.of(milk)));
        milk.setExpireDate(yesterday);
        controlQuality.resort();
        assertThat(trash.getAllFoods(), is(List.of(milk)));
    }
}