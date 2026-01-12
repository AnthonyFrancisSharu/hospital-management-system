package citynursinghome.Ui;

import citynursinghome.Implementations.Consultant;
import citynursinghome.Implementations.Patient;
import citynursinghome.Implementations.Room;
import citynursinghome.Main;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class AddNewPatient extends JFrame {
    JLabel idField;
    JComboBox<String> genderChoice;
    JTextField  nameField, numberField , ageField, diseaseField, addressField, depositField;
    Choice roomField, consultantField;
    LocalDateTime currentDate = LocalDateTime.now();
    JButton addButton, backButton;

    private final Patient patient = new Patient();
    private final Consultant consultant = new Consultant();
    private final Room room = new Room();

    AddNewPatient() {
        setUndecorated(true);
        initializeUi();

        setSize(900,650);
        setLayout(null);
        setLocation(300,150);
        setVisible(true);
    }

    private  void initializeUi(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 640);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("New Patient Form");
        titleLabel.setBounds(118, 11, 260, 53);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel idLabel = createLabel("Patient ID:", 76);
        panel.add(idLabel);

        idField = new JLabel(patient.generatePatientID());
        idField.setBounds(271, 76, 250, 20);
        idField.setForeground(Color.BLACK);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(idField);

        JLabel nameLabel = createLabel("Name:", 111);
        panel.add(nameLabel);
        nameField = createTextField(  111);
        panel.add(nameField);

        JLabel ageLabel = createLabel("Age:", 151);
        panel.add(ageLabel);
        ageField = createTextField( 151);
        panel.add(ageField);

        JLabel numberLabel = createLabel("Mobile Number:", 191);
        panel.add(numberLabel);
        numberField = createTextField( 191);
        panel.add(numberField);

        JLabel genderLabel = createLabel("Gender :", 231);
        panel.add(genderLabel);

        genderChoice = new JComboBox<>(new String[]{"Male", "Female"});
        genderChoice.setBounds( 271, 231, 250, 20);
        genderChoice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(genderChoice);

        JLabel addressLabel = createLabel("Address:", 274);
        panel.add(addressLabel);
        addressField = createTextField( 274);
        panel.add(addressField);

        JLabel diseaseLabel = createLabel("Disease:", 316);
        panel.add(diseaseLabel);
        diseaseField = createTextField( 316);
        panel.add(diseaseField);

        JLabel consultantLabel = createLabel("Consultant:", 359);
        panel.add(consultantLabel);
        consultantField = new Choice();
        populateConsultantField();
        consultantField.setBounds(271, 359, 250, 20);
        consultantField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(consultantField);

        JLabel roomLabel = createLabel("Room:", 402);
        panel.add(roomLabel);

        roomField = new Choice();
        populateRoomField();
        roomField.setBounds(271, 402, 250, 20);
        roomField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(roomField);

        JLabel dateLabel = createLabel("Admission Date:", 445);
        panel.add(dateLabel);

        JLabel dateField = new JLabel(currentDate.toString());
        dateField.setBounds(271, 445, 250, 20);
        dateField.setForeground(Color.BLACK);
        dateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(dateField);

        JLabel depositLabel = createLabel("Registration fee:", 488);
        panel.add(depositLabel);
        depositField = createTextField( 488);
        panel.add(depositField);

        backButton = new JButton("Back");
        backButton.setBounds(100, 544, 120, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> this.dispose());
        panel.add(backButton);

        addButton = new JButton("Add Patient");
        addButton.setBounds(260, 544, 120, 30);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> handleAddPatient());
        panel.add(addButton);
    }

    private JLabel createLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(35, y, 200, 20);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        return label;
    }

    private JTextField createTextField(int y) {
        JTextField textField = new JTextField();
        textField.setBounds(271, y, 250, 20);
        return textField;
    }

    private void populateConsultantField() {
        if (Main.getConsultants().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No consultants available");
        } else {
            for (Consultant consultant : Main.getConsultants()) {
                consultantField.add(consultant.getConsultantName());
            }
        }
    }

    private void populateRoomField() {
        if (Main.getRooms().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No rooms available");
        } else {
            for (Room room : Main.getRooms()) {
                if ("Available".equals(room.getRoomStatus())) {
                    roomField.add(room.getRoomId());
                }
            }
        }
    }

    private void handleAddPatient(){
        String id = idField.getText();
        String name = nameField.getText();
        String number = numberField.getText();
        String gender = (String) genderChoice.getSelectedItem();
        String address = addressField.getText();
        String disease = diseaseField.getText();
        String consultantName = consultantField.getSelectedItem();
        String roomId = roomField.getSelectedItem();
        int age = 0;
        double deposit = 0;
        double totalBill = 0;

        if (id.isEmpty() || name.isEmpty() || number.isEmpty() || disease.isEmpty() || consultantName.isEmpty() || roomId.isEmpty() || depositField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        try {
            age = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (age < 0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age above 0", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!number.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number. Must be 10 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            deposit = Double.parseDouble(depositField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid deposit amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        totalBill += deposit;

        if (deposit < 0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid deposit amount above 0", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Consultant currentConsultant = consultant.findConsultantByName(consultantName);
        Room currentRoom = room.findRoomById(roomId);

        patient.addPatient(id, name, age, gender, number, address, disease, currentDate, currentRoom, currentConsultant, currentRoom.getRoomCharge(), deposit, totalBill);
        JOptionPane.showMessageDialog(this, "Patient added successfully");
        for (Room findRoom : Main.getRooms()) {
            if (findRoom.getRoomId().equals(roomId)) {
                findRoom.setRoomStatus("Booked");
            }
        }
        this.dispose();
    }
}
