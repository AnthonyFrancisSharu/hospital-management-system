package citynursinghome.Ui;

import citynursinghome.Implementations.Manager;

import javax.swing.*;
import java.awt.*;

public class AddNewManager extends JFrame {
    JLabel idField;
    JTextField nameField, mobileField, emailField, addressField;
    JPasswordField passwordField;
    JButton addButton, backButton;

    private final Manager manager = new Manager();

    AddNewManager() {
        initializeUi();
        setUndecorated(true);
        setSize(810, 410);
        setLayout(null);
        setLocation(400, 200);
        setVisible(true);
    }

    private void initializeUi() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 800, 400);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("New Manager Form");
        titleLabel.setBounds(190, 10, 200, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(titleLabel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/managerIcon.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(250,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(480,60,250,300);
        panel.add(label);

        // Cashier ID Label
        JLabel idLabel = createLabel("Manager ID:",  50);
        panel.add(idLabel);

        idField = new JLabel(manager.generateManagerID()); // Non-editable field to display auto-generated ID
        idField.setBounds(180, 50, 250, 25);
        idField.setForeground(Color.BLACK);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(idField);

        // Name
        JLabel nameLabel = createLabel("Name:",  90);
        panel.add(nameLabel);
        nameField = createTextField( 90);
        panel.add(nameField);

        // Mobile Number
        JLabel mobileLabel = createLabel("Mobile:",  130);
        panel.add(mobileLabel);
        mobileField = createTextField( 130);
        panel.add(mobileField);

        // Email
        JLabel emailLabel = createLabel("Email:",  170);
        panel.add(emailLabel);

        emailField = createTextField( 170);
        panel.add(emailField);

        // Address
        JLabel addressLabel = createLabel("Address:",  210);
        panel.add(addressLabel);
        addressField = createTextField( 210);
        panel.add(addressField);

        // Cashier Password
        JLabel passwordLabel = createLabel("Password:",  250);
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(180, 250, 250, 25);
        panel.add(passwordField);

        backButton = new JButton("Back");
        backButton.setBounds(90, 300, 140, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> this.dispose());
        panel.add(backButton);

        // Add Button
        addButton = new JButton("Add Manager");
        addButton.setBounds(260, 300, 140, 30);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> handleAddManager());
        panel.add(addButton);
    }

    private void handleAddManager() {
        String id = idField.getText();
        String name = nameField.getText();
        String mobile = mobileField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || mobile.isEmpty() || email.isEmpty() || address.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mobile number validation (only digits, length check)
        if (!mobile.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number. Must be 10 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Email validation
        if(!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Invalid email address. Please follow the format \"example@example.com\"", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (manager.checkManagerExists(name,email)) {
            JOptionPane.showMessageDialog(this, "Manager with this name or email already exists", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Password length check
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        manager.addManager(id, name, mobile, email, address, password);
        JOptionPane.showMessageDialog(this, "Manager added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    private JLabel createLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(50, y, 200, 20);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        return label;
    }

    private JTextField createTextField(int y) {
        JTextField textField = new JTextField();
        textField.setBounds(180, y, 250, 20);
        return textField;
    }
}
