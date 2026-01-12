package citynursinghome.Ui;

import citynursinghome.Implementations.Patient;
import citynursinghome.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AllPatientsInfo extends JFrame {

    AllPatientsInfo() {
        initializeUi();
        setUndecorated(true);
        setSize(1300,600);
        setLayout(null);
        setLocation(120,200);
        setVisible(true);
    }

    private void initializeUi() {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,1290,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("All Patients Information");
        titleLabel.setBounds(550, 15, 300, 30);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setBounds(10,100,1250,450);
        table.setFont(new Font("Tahoma",Font.PLAIN,12));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10,85,1270,450);
        scrollPane.setBackground(new Color(90,156,163));
        panel.add(scrollPane);

        String[] columns = {"Patient ID", "Name", "Mobile", "Age", "Gender", "Address", "Disease", "Consultant", "Room ID", "Admit Date", "Consult Fee","Room Charge","Total Bill"};
        model.setColumnIdentifiers(columns);
        for (Patient patient : Main.getPatients()) {
            model.addRow(new Object[]{
                    patient.getPatientId(),
                    patient.getPatientName(),
                    patient.getPatientMobile(),
                    patient.getPatientAge(),
                    patient.getPatientGender(),
                    patient.getPatientAddress(),
                    patient.getPatientDisease(),
                    patient.getConsultant().getConsultantName(),
                    patient.getRoom().getRoomId(),
                    patient.getPatientAdmitDate(),
                    patient.getConsultant().getFee(),
                    patient.getRoom().getRoomCharge(),
                    patient.getPatientTotalBill()
            });
        }

        JButton button = new JButton("Back");
        button.setBounds(600,550,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(e -> this.dispose());
    }
}
