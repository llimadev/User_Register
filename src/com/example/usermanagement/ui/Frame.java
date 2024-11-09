package com.example.usermanagement.ui;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;

public class Frame extends MigLayout {
    public Frame() {

        //Creating amd initializing a panel for the frame
        JPanel panel = new JPanel(new MigLayout());
        JMenuBar menuBar = new JMenuBar();

        // Create menu items
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu configureMenu = new JMenu("Config");
        JMenu helpMenu = new JMenu("Help");

        // Add menu items to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(configureMenu);
        menuBar.add(helpMenu);

        //Creating and initializing the labels
        JLabel labelName = new JLabel("Nome");
        JLabel labelAge = new JLabel("Idade");
        JLabel labelEmail = new JLabel("E-mail");

        //Creating and initializing the form fields
        JTextField nameTextField = new JTextField();
        JTextField ageTextField = new JTextField();
        JTextField emailTextField = new JTextField();
        JButton registerButton = new JButton("Cadastrar");
        JButton viewUsersButton = new JButton("View Users");

        //Addind the components created above to the panel/frame
        panel.add(labelName);
        panel.add(nameTextField, "w 200, wrap");
        panel.add(labelAge);
        panel.add(ageTextField, "w 28, wrap");
        panel.add(labelEmail);
        panel.add(emailTextField, "width 200, span, grow, wrap");
        panel.add(registerButton, "skip");
        panel.add(viewUsersButton);

        //Creating and initializing the frame
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(400, 190);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
