package ru.job4j.ood.isp;

/**
 * Пример нарушения принципа ISP.
 * Не все повора готовят все виды кухни.
 */
public interface Cook {
    void cookJapanFood();
    void cookEuropeFood();
    void cookItalyFood();
}
