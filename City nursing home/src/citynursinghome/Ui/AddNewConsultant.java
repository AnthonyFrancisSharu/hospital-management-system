package citynursinghome.Ui;

import citynursinghome.Implementations.Consultant;

import javax.swing.*;
import java.awt.*;

public class AddNewConsultant extends JFrame {
    JLabel idField;
    JTextField nameField, specialistField, amountField, mobileField, emailField, addressField;
    JComboBox<String> genderChoice;
    JButton addButton, backButton;

    private final Consultant consultant = new Consultant();

    AddNewConsultant() {
        initializeUi();
        setUndecorated(true);
        setSize(810, 510);
        setLayout(null);
        setLocation(400, 200);
        setVisible(true);
    }

    private void initializeUi() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 800, 500);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("New Consultant Form");
        titleLabel.setBounds(130, 10, 250, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(titleLabel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/consultantIcon.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(250,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,70,250,300);
        panel.add(label);


        JLabel idLabel = createLabel("Consultant ID:",  50);
        panel.add(idLabel);

        idField = new JLabel(consultant.generateConsultantID()); // Non-editable field to display auto-generated ID
        idField.setBounds(190, 50, 250, 20);
        idField.setForeground(Color.BLACK);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(idField);

        JLabel nameLabel = createLabel("Name:",  90);
        panel.add(nameLabel);
        nameField = createTextField( 90);
        panel.add(nameField);

        JLabel specialistLabel = createLabel("Specialist:",  130);
        panel.add(specialistLabel);
        specialistField = createTextField( 130);
        panel.add(specialistField);

        JLabel genderLabel = createLabel("Gender",  170);
        panel.add(genderLabel);

        String[] genderOptions = {"Male", "Female"};
        genderChoice = new JComboBox<>(genderOptions);
        genderChoice.setBounds(190, 170, 250, 20);
        genderChoice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(genderChoice);

        JLabel mobileLabel = createLabel("Mobile:",  210);
        panel.add(mobileLabel);

        mobileField = createTextField( 210);
        panel.add(mobileField);

        JLabel emailLabel = createLabel("Email:",  250);
        panel.add(emailLabel);

        emailField = createTextField( 250);
        panel.add(emailField);

        JLabel addressLabel = createLabel("Address:",  290);
        panel.add(addressLabel);

        addressField = createTextField( 290);
        panel.add(addressField);

        JLabel amountLabel = createLabel("Consultation fee:",  330);
        panel.add(amountLabel);

        amountField = createTextField( 330);
        panel.add(amountField);

        backButton = new JButton("Back");
        backButton.setBounds(90, 400, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> this.dispose());
        panel.add(backButton);

        addButton = new JButton("Add Consultant");
        addButton.setBounds(260, 400, 140, 30);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> handleAddConsultant());
        panel.add(addButton);
    }

    private void handleAddConsultant(){
         String id = idField.getText();
         String name = nameField.getText();
         String gender = (String) genderChoice.getSelectedItem();
         String mobile = mobileField.getText();
         String email = emailField.getText();
         String address = addressField.getText();
         String specialist = specialistField.getText();
         double amount = 0;

        if (name.isEmpty() || mobile.isEmpty() || email.isEmpty() || address.isEmpty() || specialist.isEmpty() || amountField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!mobile.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number. Must be 10 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Invalid email address. Please follow the format \"example@example.com\"", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(consultant.checkConsultantExists(name, email)) {
            JOptionPane.showMessageDialog(this, "Consultant with this name or email already exists", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (amount < 0) {
            JOptionPane.showMessageDialog(null, "Please enter an amount above 0", "Error", JOptionPane.ERROR_MESSAGE);
        }

        consultant.addConsultant(id, name, specialist, gender, mobile, email, address, amount);
        JOptionPane.showMessageDialog(null, "Consultant Added Successfully!");
        this.dispose();
    }

    private JLabel createLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(40, y, 200, 20);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        return label;
    }

    private JTextField createTextField( int y) {
        JTextField textField = new JTextField();
        textField.setBounds(190, y, 250, 20);
        return textField;
    }
}
