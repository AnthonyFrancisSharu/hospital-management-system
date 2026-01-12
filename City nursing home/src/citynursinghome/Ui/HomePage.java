package citynursinghome.Ui;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {
    private final String role;
    HomePage(String role) {
        this.role = role;
        initializeUi();
        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    private void initializeUi(){
        boolean visibility = !role.equals("Cashier");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,670);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dr.png"));
        Image image = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1300,0,250,250);
        panel1.add(label);

//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/amb.png"));
//        Image image1 = i11.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
//        ImageIcon i22 = new ImageIcon(image);
//        JLabel label1 = new JLabel(i2);
//        label1.setBounds(1000,50,300,100);
//        panel1.add(label1);

        JButton btn1 =new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(246,215,118));
        panel1.add(btn1);
        btn1.addActionListener(e -> new AddNewPatient());

        JButton btn2 =new JButton("Add New Consultant");
        btn2.setBounds(270,15,200,30);
        btn2.setBackground(new Color(246,215,118));
        panel1.add(btn2);
        btn2.addActionListener(e -> new AddNewConsultant());

        JButton btn3 = new JButton("Add New Room");
        btn3.setBounds(510,15,200,30);
        btn3.setBackground(new Color(246,215,118));
        panel1.add(btn3);
        btn3.addActionListener(e -> new AddNewRoom());

        JButton btn4 = new JButton("Add New Cashier");
        btn4.setBounds(750,15,200,30);
        btn4.setBackground(new Color(246,215,118));
        btn4.setVisible(visibility);
        panel1.add(btn4);
        btn4.addActionListener(e -> new AddNewCashier());

        JButton btn5 =new JButton("Add New Manager");
        btn5.setBounds(990,15,200,30);
        btn5.setBackground(new Color(246,215,118));
        btn5.setVisible(visibility);
        panel1.add(btn5);
        btn5.addActionListener(e -> new AddNewManager());

        JButton btn6 =new JButton("View Patients");
        btn6.setBounds(30,58,200,30);
        btn6.setBackground(new Color(246,215,118));
        panel1.add(btn6);
        btn6.addActionListener(e -> new AllPatientsInfo());

        JButton btn7 =new JButton("View / Search Consultants");
        btn7.setBounds(270,58,200,30);
        btn7.setBackground(new Color(246,215,118));
        panel1.add(btn7);
        btn7.addActionListener(e -> new SearchConsultent());

        JButton btn8 =new JButton("View Rooms");
        btn8.setBounds(510,58,200,30);
        btn8.setBackground(new Color(246,215,118));
        panel1.add(btn8);
        btn8.addActionListener(e -> new AllRoomsInfo());


        JButton btn9 =new JButton("View Cashiers");
        btn9.setBounds(750,58,200,30);
        btn9.setBackground(new Color(246,215,118));
        btn9.setVisible(visibility);
        panel1.add(btn9);
        btn9.addActionListener(e -> new AllCashiersInfo());

        JButton btn10 =new JButton("View Managers");
        btn10.setBounds(990,58,200,30);
        btn10.setBackground(new Color(246,215,118));
        btn10.setVisible(visibility);
        panel1.add(btn10);
        btn10.addActionListener(e -> new AllManagersInfo());

        JButton btn11 =new JButton("Logout");
        btn11.setBounds(30,100,200,30);
        btn11.setBackground(new Color(246,215,118));
        panel1.add(btn11);
        btn11.addActionListener(e -> new Logout());
    }
}
