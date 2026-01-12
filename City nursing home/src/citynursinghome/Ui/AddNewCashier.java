package citynursinghome.Ui;

import citynursinghome.Implementations.Cashier;

import javax.swing.*;
import java.awt.*;

public class AddNewCashier extends JFrame {
    JLabel idField;
    JTextField nameField, mobileField, emailField, addressField;
    JPasswordField passwordField;
    JButton addButton, backButton;

    private final Cashier cashier = new Cashier();

    AddNewCashier() {
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

        JLabel titleLabel = new JLabel("New Cashier Form");
        titleLabel.setBounds(130, 10, 200, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(titleLabel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/cashierIcon.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,50,250,250);
        panel.add(label);

        // ID (Auto-generated)
        JLabel idLabel = createLabel("Cashier ID :",  50);
        panel.add(idLabel);

        idField = new JLabel(cashier.generateCashierID()); // Auto-generated ID
        idField.setBounds(180, 50, 250, 20);
        idField.setForeground(Color.BLACK);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(idField);

        // Name
        JLabel nameLabel = createLabel("Name :",  90);
        panel.add(nameLabel);
        nameField = createTextField( 90);
        panel.add(nameField);

        // Mobile
        JLabel mobileLabel = createLabel("Mobile :",  130);
        panel.add(mobileLabel);
        mobileField = createTextField( 130);
        panel.add(mobileField);

        // Email
        JLabel emailLabel = createLabel("Email :",  170);
        panel.add(emailLabel);
        emailField = createTextField( 170);
        panel.add(emailField);

        // Address
        JLabel addressLabel = createLabel("Address :",  210);
        panel.add(addressLabel);
        addressField = createTextField( 210);
        panel.add(addressField);

        // Password
        JLabel passwordLabel = createLabel("Password :",  250);
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(180, 250, 250, 20);
        panel.add(passwordField);

        // Buttons
        backButton = new JButton("Back");
        backButton.setBounds(90, 300, 140, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> this.dispose());
        panel.add(backButton);

        addButton = new JButton("Add Cashier");
        addButton.setBounds(260, 300, 140, 30);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> handleAddCashier());
        panel.add(addButton);
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

    private void handleAddCashier() {
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

        if(!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Invalid email address. Please follow the format \"example@example.com\"", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(cashier.checkCashierExists(name, email)) {
            JOptionPane.showMessageDialog(this, "Cashier with this name or email already exists", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cashier.addCashier(id, name, mobile, email, address, password);
        JOptionPane.showMessageDialog(this, "Cashier added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }
}
