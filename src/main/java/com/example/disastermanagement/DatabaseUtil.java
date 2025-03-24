package com.example.disastermanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/disaster_management";
    private static final String USER = "root";
    private static final String PASSWORD = "Slg2398$&hd24114@#"; // Change this to your MySQL password

    static {
        try {
            // Explicitly load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load MySQL driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Create the disaster_reports table if it doesn't exist
    public static void initializeDatabase() {
        try (Connection conn = getConnection()) {
            String createTableSQL = """
                CREATE TABLE IF NOT EXISTS disaster_reports (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    type_of_disaster VARCHAR(50),
                    date_of_incident DATE,
                    time_of_incident VARCHAR(10),
                    impact_description TEXT,
                    affected_individuals INT,
                    urgency_level VARCHAR(20),
                    full_name VARCHAR(100),
                    contact_number VARCHAR(20),
                    email VARCHAR(100),
                    national_id VARCHAR(20),
                    street_address VARCHAR(200),
                    grama_niladhari VARCHAR(100),
                    district VARCHAR(50),
                    province VARCHAR(50),
                    status VARCHAR(20) DEFAULT 'Pending',
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
            """;

            conn.createStatement().execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize database", e);
        }
    }
}
