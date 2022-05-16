package ru.job4j.ood.srp;

public final class Singleton {
    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
/**Singleton нарушает принцип srp, так как класс помимо своих основных обязанностей класс занимается еще
и контролированием количества своих экземпляров*/