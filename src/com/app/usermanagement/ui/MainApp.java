package com.app.usermanagement.ui;

import com.app.usermanagement.config.DatabaseConfig;
import com.app.usermanagement.model.User;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            FontUIResource font = new FontUIResource("Arial", Font.PLAIN, 14);
            UIManager.put("Label.font", font);
            UIManager.put("Button.font", font);
            UIManager.put("TextField.font", font);

            // Adding users to the database
            new User("Max");
            new User("Pedro");
            new User("Maria");
            new User("Jose");
            new User("Ana");
            new User("Leonardo");
            DatabaseConfig.getAllUsers(); // Showing users from the Database

            new Frame();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
