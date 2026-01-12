package citynursinghome.Ui;

import citynursinghome.Implementations.Consultant;
import citynursinghome.Implementations.Room;
import citynursinghome.Main;

import javax.swing.*;
import java.awt.*;

public class AddNewRoom extends JFrame {
    JLabel idField;
    JTextField paymentField, mobileNumberField;
    JComboBox<String> availabilityBox, roomTypeBox;
    JButton addButton, backButton;

    private final Room room = new Room();

    AddNewRoom() {
        initializeUi();
        setUndecorated(true);
        setSize(810, 410);
        setLocation(400, 200);
        setLayout(null);
        setVisible(true);
    }

    private void initializeUi() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 800, 400);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("New Room Form");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setBounds(190, 20, 200, 30);
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,50,250,250);
        panel.add(label);


        JLabel roomNumberLabel = createLabel("Room ID :", 50, 50);
        panel.add(roomNumberLabel);

        idField = new JLabel(room.generateRoomID()); // Non-editable field to display auto-generated ID
        idField.setBounds(180, 50, 250, 20);
        idField.setForeground(Color.BLACK);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(idField);

        JLabel roomTypeLabel = createLabel("Room Type:", 50, 90);
        panel.add(roomTypeLabel);

        String[] roomTypeOptions = {"Normal", "Private", "Icu"};
        roomTypeBox = new JComboBox<>(roomTypeOptions);
        roomTypeBox.setBounds(180, 90, 250, 20);
        panel.add(roomTypeBox);


        JLabel availabilityLabel = createLabel("Availability :", 50, 130);
        panel.add(availabilityLabel);

        String[] availabilityOptions = {"Available", "Booked"};
        availabilityBox = new JComboBox<>(availabilityOptions);
        availabilityBox.setBounds(180, 130, 250, 20);
        availabilityBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(availabilityBox);

        JLabel mobileNumberLabel = createLabel("Mobile :", 50, 170);
        panel.add(mobileNumberLabel);
        mobileNumberField = createTextField(180, 170);
        panel.add(mobileNumberField);

        JLabel paymentLabel = createLabel("Room Charge:", 50, 210);
        panel.add(paymentLabel);
        paymentField = createTextField(180, 210);
        panel.add(paymentField);

        backButton = new JButton("Back");
        backButton.setBounds(90, 300, 140, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> this.dispose());
        panel.add(backButton);

        addButton = new JButton("Add Room");
        addButton.setBounds(260, 300, 140, 30);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> handleAddRoom());
        panel.add(addButton);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 200, 20);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 250, 20);
        return textField;
    }

    private void handleAddRoom() {
        String roomNo = idField.getText();
        String availability = (String) availabilityBox.getSelectedItem();
        String roomType = (String) roomTypeBox.getSelectedItem();
        String mobileNumber = mobileNumberField.getText();
        double fee = 0;

        if (availability.isEmpty() || paymentField.getText().isEmpty() || roomType.isEmpty() || mobileNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!mobileNumber.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number. Must be 10 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            fee = Double.parseDouble(paymentField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(fee < 0 ){
            JOptionPane.showMessageDialog(this, "Please enter a valid amount above 0", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        room.addRoom(roomNo, roomType, fee, mobileNumber, availability);
        JOptionPane.showMessageDialog(this, "Room Added Successfully");
        this.dispose();

    }
}
