package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DIPViolation {
    private HashSet<Integer> hashSet = new HashSet<>();

}

class DIPViolation2 {

    public ArrayList<String> list() {
        //...
        return new ArrayList<>();
    }
}

class DIPViolation3 {
    private Map<Integer, Integer> map;

    public DIPViolation3(HashMap<Integer, Integer> map) {
        this.map = map;
    }
}