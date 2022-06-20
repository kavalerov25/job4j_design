package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 1. Нарушение DIP - в поле класса прямая зависимость от конкретной реализации.
 */
public class DIPViolation {
    private HashSet<Integer> hashSet = new HashSet<>();

}

/**
 * 2. Нарушение DIP - возвращаемое значение метода имеет конкретную реализацию.
 */
class DIPViolation2 {

    public ArrayList<String> list() {
        //...
        return new ArrayList<>();
    }
}

/**
 * 3. Нарушение DIP - аргумент конструктора имеет конкретную реализацию.
 */
class DIPViolation3 {
    private Map<Integer, Integer> map;

    public DIPViolation3(HashMap<Integer, Integer> map) {
        this.map = map;
    }
}