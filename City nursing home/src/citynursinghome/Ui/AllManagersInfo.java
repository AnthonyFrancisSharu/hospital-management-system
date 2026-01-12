package citynursinghome.Ui;

import citynursinghome.Implementations.Manager;
import citynursinghome.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AllManagersInfo extends JFrame {

    AllManagersInfo() {
        initializeUi();
        setUndecorated(true);
        setSize(900, 600);
        setLocation(350, 230);
        setLayout(null);
        setVisible(true);
    }

    private void initializeUi() {
        // Panel Setup
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("View Manager Information");
        titleLabel.setBounds(300, 15, 300, 30);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/viewManager.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,130,300,300);
        panel.add(label);


        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setBounds(10, 34, 980, 450);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 100, 500, 400);
        scrollPane.setBackground(new Color(90, 156, 163));
        panel.add(scrollPane);

        String[] columns = {"Id", "Name", "Mobile", "Email", "Address"};
        model.setColumnIdentifiers(columns);
        for (Manager manager : Main.getManagers()) {
            model.addRow(new Object[]{
                    manager.getUserId(),
                    manager.getUserName(),
                    manager.getUserMobile(),
                    manager.getUserEmail(),
                    manager.getUserAddress()
            });
        }

        // Back Button
        JButton button = new JButton("Back");
        button.setBounds(400, 530, 120, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(e -> this.dispose());
    }
}
