package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Config configApp = new Config("./data/app.properties");
        configApp.load();
        String driver = configApp.value("driver");
        String url = configApp.value("url");
        String login = configApp.value("login");
        String password = configApp.value("password");
        Class.forName(driver);

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}