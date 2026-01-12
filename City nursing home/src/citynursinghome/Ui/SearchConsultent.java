package citynursinghome.Ui;

import citynursinghome.Implementations.Consultant;
import citynursinghome.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SearchConsultent extends JFrame {
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;
    JButton search, back;

    private final Consultant consultant = new Consultant();

    SearchConsultent() {
        initializeUi();
        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(350, 230);
        setVisible(true);
    }

    private void initializeUi(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("View / Search Consultants");
        titleLabel.setBounds(300, 15, 300, 30);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        JLabel specialistLabel = new JLabel("Search By :");
        specialistLabel.setBounds(140, 90, 100, 20);
        specialistLabel.setForeground(Color.WHITE);
        specialistLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(specialistLabel);

        String[] searchOptions = {"Specialization", "Name"};
        JComboBox<String> searchType = new JComboBox<>(searchOptions);
        searchType.setBounds(280, 90, 250, 20);
        searchType.setBackground(Color.WHITE);
        searchType.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(searchType);

        JLabel searchTerm = new JLabel("Enter search term :");
        searchTerm.setBounds(140, 140, 200, 20);
        searchTerm.setForeground(Color.WHITE);
        searchTerm.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(searchTerm);

        JTextField searchField = new JTextField();
        searchField.setBounds(280, 140, 250, 20);
        searchField.setBackground(Color.WHITE);
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(searchField);

        model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setBounds(40, 240, 800, 450);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 240, 800, 250);
        panel.add(scrollPane);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/viewConsultant.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(220,220,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(620,20,220,220);
        panel.add(label);

        String[] columns = {"ID", "Name", "Specialization", "Gender","Mobile", "Email", "Address", "Consult Fee"};
        model.setColumnIdentifiers(columns);
        for (Consultant consultant : Main.getConsultants()) {
            model.addRow(new Object[]{consultant.getConsultantId(), consultant.getConsultantName(), consultant.getConsultantSpecialization(), consultant.getConsultantGender(), consultant.getConsultantMobile(), consultant.getConsultantEmail(), consultant.getConsultantAddress(), consultant.getFee()});
        }

        search = new JButton("Search");
        search.setBounds(450, 500, 120, 30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(e -> searchConsultants(searchField.getText(), searchType.getSelectedItem().toString()));

        back = new JButton("Back");
        back.setBounds(300, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(e -> this.dispose());

    }
    private void searchConsultants(String term, String searchType) {
        model.setRowCount(0);
        if (term.isEmpty()) {
            addToModel(Main.getConsultants());
        } else if(searchType.equals("Specialization")) {
            ArrayList<Consultant> filteredConsultants = consultant.findConsultantBySpecialization(term);
            addToModel(filteredConsultants);

        } else if(searchType.equals("Name")) {
            ArrayList<Consultant> filteredConsultants = consultant.findConsultantContainingName(term);
            addToModel(filteredConsultants);
        }
    }

    private void addToModel(ArrayList<Consultant> consultants) {
        for (Consultant consultant : consultants) {
            model.addRow(new Object[]{
                    consultant.getConsultantId(),
                    consultant.getConsultantName(),
                    consultant.getConsultantSpecialization(),
                    consultant.getConsultantGender(),
                    consultant.getConsultantMobile(),
                    consultant.getConsultantEmail(),
                    consultant.getConsultantAddress(),
                    consultant.getFee()
            });
        }
    }
}
