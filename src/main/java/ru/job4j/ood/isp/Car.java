package ru.job4j.ood.isp;

/**
 * Пример нарушения принципа ISP.
 * Не все автомобили имеют подушки безопасности. Например, российский Москвич;
 */
public interface Car {
    void drive();
    void stop();
    void safetyPillows();
}
