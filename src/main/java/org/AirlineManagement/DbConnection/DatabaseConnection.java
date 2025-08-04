package org.AirlineManagement.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection connect() {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;databaseName=AirLineDb;user=airlineUser;password=airline;encrypt=false;";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            System.out.println("✅ Verbonden met database!");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Fout bij verbinding: " + e.getMessage());
            return null;
        }
    }
}
