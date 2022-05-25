package ru.job4j.ood.lsp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void perimeter() {
        Rectangle rectangle = initRectangle();
        rectangle.setHeight(5);
        rectangle.setWidth(7);

        int result = rectangle.perimeter();

        assertEquals(24, result);
    }

    protected Rectangle initRectangle() {
        return new Rectangle();
    }

    public class SquareTest extends RectangleTest {

        @Override
        protected Rectangle initRectangle() {
            return new Square();
        }
    }
    /**
    Классический пример.
     провалится, так как результат вызова функции perimeter будет не 24, как написано в тесте, а 28.
     И тут мы должны задать себе очень важный вопрос: правильно ли написан тест, в котором предполагается,
     что при изменении длины прямоугольника его ширина не изменяется?
     Очевидно — да. Наш тест наглядно демонстрирует код, который корректно работает с объектом класса Rectangle,
     но ломается при работе с объектами класса Square.
     То есть не для каждого объекта типа Square существует объект типа Rectangle такой,
     что определённая в терминах Rectangle программа (в данном случае тест) не меняется,
     если вместо объекта типа Rectangle подставить объект типа Square.
     Следовательно Square — не подтип Rectangle, следовательно LSP нарушается.
     https://www.pvsm.ru/java/348365
     */

}

