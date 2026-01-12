package citynursinghome.Ui;

import citynursinghome.Implementations.StorageFunctions;

import javax.swing.*;
import java.awt.*;

public class Logout extends JFrame{

    JButton saveButton, cancelButton;

    private final StorageFunctions storageFunctions = new StorageFunctions();
    public Logout() {
        initializeUi();
        getContentPane().setBackground(new Color(189, 164, 170));
        setSize(600, 300);
        setUndecorated(true);
        setLocation(400, 270);
        setLayout(null);// Setting layout before adding components
        setVisible(true);
    }

    private void initializeUi() {
        JLabel logOutMessage = new JLabel("Do you wish to save changes and logout?");
        logOutMessage.setBounds(130, 70, 400, 30);
        logOutMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
        logOutMessage.setForeground(Color.BLACK);
        add(logOutMessage);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 150, 100, 30);
        saveButton.setBackground(new Color(246, 215, 118));
        saveButton.setForeground(Color.BLACK);
        saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        saveButton.addActionListener(e -> saveChanges());
        add(saveButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(350, 150, 100, 30);
        cancelButton.setBackground(new Color(246, 215, 118));
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);
    }

    private void saveChanges(){
        if(storageFunctions.saveChanges()) {
            JOptionPane.showMessageDialog(this, "Data Stored to File successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error Storing Data to File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
