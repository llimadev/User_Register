package com.app.usermanagement.config;

import com.app.usermanagement.model.User;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConfig {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/" + dotenv.get("DB_NAME");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    // Adding logger for error control
    private static final Logger LOGGER = Logger.getLogger(DatabaseConfig.class.getName());

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Savind users to the database
    public static void saveUser(User user) {
        String sql = "INSERT INTO users (name) VALUES (?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error saving user: " + user.getName(), e);
        }
    }

    // Listing all users from the database
    public static List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                User user = new User(name);
                users.add(user);
            }
            users.forEach(u -> System.out.println("User Found: " + u));
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving users", e);
        }
        return users;
    }

    // Deleting all users from the database
    public static void deleteAllUsers() {
        String sql = "DELETE FROM users";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted + " rows deleted.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting users", e);
        }
    }
}