package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.Scanner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = System.out::println;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var menu = new SimpleMenu();
        boolean run = true;
        while (run) {
            showMenu();
            run = execute(menu, scanner.nextLine(), new MenuPrinterImpl());
        }
    }

    private static boolean execute(Menu menu, String answer, MenuPrinter menuPrinter) {
        boolean rsl = true;
        switch (answer) {
            case "1":
                System.out.println("Введите имя новой задачи:");
                menu.add(Menu.ROOT, scanner.nextLine(), STUB_ACTION);
                break;
            case "2":
                System.out.println("Введите имя задачи:");
                var parentName = scanner.nextLine();
                System.out.println("Введите имя подзадачи:");
                var childName = scanner.nextLine();
                menu.add(parentName, childName, STUB_ACTION);
                break;
            case "3":
                menuPrinter.print(menu);
                break;
            case "4":
                rsl = false;
                break;
            default:
                System.out.println("Введите цифру от 1 до 4.");
                break;
        }
        return rsl;
    }

    private static void showMenu() {
        System.out.println("Меню:");
        List.of("1. Добавить новую задачу", "2. Добавить подзадачу", "3. Показать список задач", "4. Выход")
                .forEach(System.out::println);
    }
}