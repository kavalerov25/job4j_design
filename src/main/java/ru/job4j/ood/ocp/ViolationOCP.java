package ru.job4j.ood.ocp;

import java.util.ArrayList;

public class ViolationOCP {
    static class Example1 {

        class SmtpMailer {

            private Logger logger;

            public SmtpMailer() {
                logger = new Logger();
            }

            public void sendMessage(String message) {
                /** отсылка сообщения */
                logger.log(String.format("Отправлено '{0}'", message));
            }

            class Logger {
                public void log(String logText) {
                    /**
                     Пишем логи в файл, но если потребуется писать в базу данных
                     то придется переписывать метод.
                     */
                }
            }
        }
    }

    /**
     * --------------------------------------------------------------------------------------------
     */

    static class Example2 {
        ArrayList<Integer> arrayList;

        public Example2(ArrayList<Integer> arrayList) {
            this.arrayList = arrayList;
        }
        /**
         2. Нарушение OCP - поля должны представлять тип абстракций, а не
         конкретной реализации.
         OCP можно назвать использование Integer,
         Также вместо Integer использовать Generic. Это лишает нас возможности выводить списки с другими типами данных.
         */
    }

    /**
     * --------------------------------------------------------------------------------------------
     */

    static class Example3 {

        public ArrayList<Integer> sort(ArrayList<Integer> arrayList) {
            /**some logic*/
            return arrayList;
        }
        /**
         3. Нарушение OCP - параметры метода и возвращаемые типы должны
         быть абстракциями, а не конкретными реализациями.
         Взаимодействие должно осуществляться через абстракции, в данном случае через интерфейс List.
         */
    }
}
