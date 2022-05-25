package ru.job4j.ood.lsp;

public class Bird {

    public void fly() {
    }

    class Duck extends Bird {
    }

    class Ostrich extends Bird {
    }

    /**Страус - это птица, но он не может летать, класс Страус - это подтип класса Bird,
     но он не может использовать метод fly, это означает, что мы нарушаем принцип LSP.
     */
}
