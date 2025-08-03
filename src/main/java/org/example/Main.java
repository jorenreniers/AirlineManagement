package org.example;

import DbConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        DatabaseConnection.connect();

    }
}