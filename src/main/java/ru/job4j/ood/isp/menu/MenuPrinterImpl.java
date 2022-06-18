package ru.job4j.ood.isp.menu;

public class MenuPrinterImpl implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        menu.forEach(i -> System.out.println("\t".repeat(i.getNumber().split("\\.").length - 1)
                                             + i.getNumber() + i.getName()));

    }
}

