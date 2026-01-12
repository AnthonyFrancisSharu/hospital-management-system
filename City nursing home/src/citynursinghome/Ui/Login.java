
package citynursinghome.Ui;
import citynursinghome.Implementations.Cashier;
import citynursinghome.Implementations.Manager;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    JTextField textField;
    JPasswordField jPasswordField;
    JComboBox<String> roleChoice;
    JButton loginButton;

    private final Cashier cashier = new Cashier();
    private final Manager manager = new Manager();

    public Login() {
        initializeGui();
        getContentPane().setBackground(new Color(189, 164, 170));
        setSize(750, 300);
        setLocation(400, 270);
        setLayout(null);// Setting layout before adding components
        setVisible(true);
    }

    private void initializeGui() {
        JLabel roleType = new JLabel("Role:");
        roleType.setBounds(40, 20, 100, 30);
        roleType.setFont(new Font("Tahoma", Font.BOLD, 16));
        roleType.setForeground(Color.BLACK);
        add(roleType);

        String[] roleOptions = {"Cashier", "Manager"};
        roleChoice = new JComboBox<>(roleOptions);
        roleChoice.setBounds(150, 20, 150, 30);
        add(roleChoice);


        JLabel namelabel = new JLabel("User ID: ");
        namelabel.setBounds(40, 70, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK); // Fixed 'color.BLACK' to 'Color.BLACK'
        add(namelabel);

        textField = new JTextField();
        textField.setBounds(150, 70, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 179, 0));
        add(textField);

        JLabel password = new JLabel("Password: ");
        password.setBounds(40, 120, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 120, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15)); // Fixed: Applied to jPasswordField
        jPasswordField.setBackground(new Color(255, 179, 0)); // Fixed: Applied to jPasswordField
        add(jPasswordField);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/loginIcon.jpg"));
        Image i1 = imageIcon.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(360,30,300,200);
        add(label);

        loginButton = new JButton("Login");
        loginButton.setBounds(120,180,120,30);
        loginButton.setFont(new Font("serif",Font.BOLD,15));
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.white);
        loginButton.addActionListener(e -> loginValidation());
        add(loginButton);
    }

    private void loginValidation() {
        String userName = textField.getText();
        String password = new String(jPasswordField.getPassword());
        String role = (String) roleChoice.getSelectedItem();

        if(userName.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username and password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (role.equals("Manager")) {
            if (!userName.startsWith("M")) {
                JOptionPane.showMessageDialog(this, "Not a manager, please enter a valid manager username", "Error", JOptionPane.ERROR_MESSAGE);
                Manager manager = new Manager();
                manager.displayRole();
            } else {
                if (manager.managerLogin(userName, password)) {
                    JOptionPane.showMessageDialog(this, "Manager Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    navigateToHomePage(role);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (role.equals("Cashier")) {
            if (!userName.startsWith("CA")) {
                JOptionPane.showMessageDialog(this, "Not a cashier, please enter a valid cashier username", "Error", JOptionPane.ERROR_MESSAGE);
                Cashier cashier = new Cashier();
                cashier.displayRole();
            } else {
                if (cashier.cashierLogin(userName, password)) {
                    JOptionPane.showMessageDialog(this, "Cashier Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    navigateToHomePage(role);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void navigateToHomePage(String role) {
        HomePage homePage = new HomePage(role); // Replace with your actual main page class
        homePage.setVisible(true);
        this.dispose(); // Close the login window
    }
}
