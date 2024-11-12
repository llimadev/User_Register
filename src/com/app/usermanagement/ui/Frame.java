package com.app.usermanagement.ui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class Frame extends MigLayout {

    public Frame() {

        // Creating a panel for the frame
        JPanel panel = new JPanel(new MigLayout());
        JMenuBar menuBar = new JMenuBar();

        // Create menu items
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        // Add menu items to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // Creating and initializing the labels
        JLabel labelName = new JLabel("Nome");
        JLabel labelAge = new JLabel("Idade");
        JLabel labelEmail = new JLabel("E-mail");

        // Creating and initializing the form fields
        JTextField nameTextField = new JTextField();
        JTextField ageTextField = new JTextField();
        ageTextField.setDocument(Common.limitChar(3)); //Applying a limit of 3 char in this field
        JTextField emailTextField = new JTextField();
        JButton registerButton = new JButton("Cadastrar");
        JButton viewUsersButton = new JButton("Ver usuários");

        // Adding the components created above to the panel/frame
        panel.add(labelName);
        panel.add(nameTextField, "w 200, wrap");
        panel.add(labelAge);
        panel.add(ageTextField, "w 28, wrap");
        panel.add(labelEmail);
        panel.add(emailTextField, "width 200, span, grow, wrap");
        panel.add(registerButton, "skip");
        panel.add(viewUsersButton);

        // Creating and initializing the frame
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(400, 190);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.setVisible(true);
    }
}
