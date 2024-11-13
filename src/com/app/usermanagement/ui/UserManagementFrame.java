package com.app.usermanagement.ui;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class UserManagementFrame extends JFrame {

    public UserManagementFrame() {
        initUI();
    }

    private void initUI() {

        // Basic JFrame configuration
        setTitle("User Management");
        setResizable(false);
        setSize(400, 190);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu configuration
        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);

        // Main panel configuration with MigLayout
        JPanel panel = createMainPanel();
        add(panel);

        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Creating menus and adding to the menu bar
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new MigLayout());

        // Creating and configuring components
        JLabel labelName = new JLabel("Nome");
        JTextField nameTextField = new JTextField(20);

        JLabel labelAge = new JLabel("Idade");
        JTextField ageTextField = new JTextField(3);
        ageTextField.setDocument(Common.limitChar(3)); // Limiting input to 3 characters

        JLabel labelEmail = new JLabel("E-mail");
        JTextField emailTextField = new JTextField(20);

        JButton registerButton = new JButton("Cadastrar");
        JButton viewUsersButton = new JButton("Ver usuários");

        // Adding the components to the panel
        panel.add(labelName);
        panel.add(nameTextField, "w 200, wrap");
        panel.add(labelAge);
        panel.add(ageTextField, "w 28, wrap");
        panel.add(labelEmail);
        panel.add(emailTextField, "w 200, span, grow, wrap");
        panel.add(registerButton, "skip");
        panel.add(viewUsersButton);

        return panel;
    }

}

