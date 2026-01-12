package citynursinghome.Ui;

import citynursinghome.Implementations.Cashier;
import citynursinghome.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AllCashiersInfo extends JFrame {
    AllCashiersInfo() {
        initializeUi();
        setUndecorated(true);
        setSize(900, 600);
        setLocation(350, 230);
        setLayout(null);
        setVisible(true);
    }

    private void initializeUi() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("View Cashiers Information");
        titleLabel.setBounds(300, 10, 300, 30);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/viewCashier.jpg"));
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
        table.setFont(new Font("Tahoma", Font.PLAIN, 12 ));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 100, 500, 400);
        scrollPane.setBackground(new Color(90,156,163));
        panel.add(scrollPane);

        String[] columns = {"Id", "Name", "Mobile", "Email", "Address"};
        model.setColumnIdentifiers(columns);
        for (Cashier cashier : Main.getCashiers()) {
            model.addRow(new Object[]{
                    cashier.getUserId(),
                    cashier.getUserName(),
                    cashier.getUserMobile(),
                    cashier.getUserEmail(),
                    cashier.getUserPassword()
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
