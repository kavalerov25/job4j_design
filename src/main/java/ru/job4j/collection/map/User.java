package ru.job4j.collection.map;

import java.util.*;

public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Kir", 0, new GregorianCalendar(1990, 4, 24));
        User user2 = new User("Kir", 0, new GregorianCalendar(1990, 4, 24));

        System.out.println("Какие у них хэш-коды?");
        System.out.println("User1 hashcode: " + user1.hashCode());
        System.out.println("User2 hashcode: " + user2.hashCode());

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        map.forEach((key, value) -> System.out.println("Key : " + key + "  Value : " + value));
    }

    @Override
    public String toString() {
        return "User{"
               + "name='" + name + '\''
               + ", children=" + children
               + ", birthday=" + birthday
               + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name)
                                         && Objects.equals(birthday, user.birthday);
    }
}



