package com.app.usermanagement.ui;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp {

    private static final Logger LOGGER = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        setLookAndFeel();

        // Launching the main application UI
        SwingUtilities.invokeLater(UserManagementFrame::new);
    }

    private static void setLookAndFeel() {
        try {
            // Attempting to set Windows LookAndFeel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.WARNING, "Windows LookAndFeel not available, setting default.", ex);
        }

        // Set global font style for UI components
        FontUIResource font = new FontUIResource("Arial", Font.PLAIN, 14);
        UIManager.put("Label.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("TextField.font", font);
    }
}