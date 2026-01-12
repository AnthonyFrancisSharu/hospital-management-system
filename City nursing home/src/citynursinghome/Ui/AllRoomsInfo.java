package citynursinghome.Ui;

import citynursinghome.Implementations.Room;
import citynursinghome.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AllRoomsInfo extends JFrame {
    AllRoomsInfo() {
        initializeUi();
        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);
    }

    private void initializeUi(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("View Rooms Information");
        titleLabel.setBounds(300, 15, 300, 30);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/viewRoom.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        DefaultTableModel model = new DefaultTableModel();
        JTable table  = new JTable(model);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setBounds(10, 34, 980, 450);
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        table.setBackground(new Color(109, 164, 170));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 100, 500, 400);
        scrollPane.setBackground(new Color(90,156,163));
        panel.add(scrollPane);

        String[] columns = {"Room No", "Room Type", "Charges", "Availability", "Mobile"};
        model.setColumnIdentifiers(columns);
        for(Room room : Main.getRooms()) {
            model.addRow(new Object[]{
                    room.getRoomId(),
                    room.getRoomType(),
                    room.getRoomCharge(),
                    room.getRoomStatus(),
                    room.getRoomMobile()
            });
        }

        JButton back = new JButton("Back");
        back.setBounds(400,530,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(e -> this.dispose());
    }

    public static void main(String[] args) {
        new AllRoomsInfo();
    }
}
