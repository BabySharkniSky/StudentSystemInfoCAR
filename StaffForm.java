/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.form;

/**
 *
 * @author Maine
 */

import studentinfo.controller.*;
import studentinfo.util.Kulay;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StaffForm extends JPanel {

    private CustomTable table;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private List<Object[]> staffData = new ArrayList<>();

    public StaffForm() {
        setLayout(new BorderLayout());
        setBackground(Kulay.VAPOROUS_GRAY);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setOpaque(false);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        topPanel.setOpaque(false);

        searchField = new JTextField(20);
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchField.setForeground(Kulay.CAVIAR);
        searchField.setPreferredSize(new Dimension(250, 35));
        searchField.setBorder(BorderFactory.createLineBorder(Kulay.BORDER_NEUTRAL, 2));

        CustomButton searchButton = new CustomButton("Search");
        searchButton.setPreferredSize(new Dimension(120, 40));
        searchButton.addActionListener(e -> searchStaff());
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchButton.setBackground(Kulay.BLUE);
        searchButton.setForeground(Kulay.WHITE);

        CustomButton refreshButton = new CustomButton("Refresh");
        refreshButton.setPreferredSize(new Dimension(120, 40));
        refreshButton.addActionListener(e -> refreshTable());
        refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(refreshButton);

        RoundPanel tablePanel = createTablePanel();

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
    }

    private RoundPanel createTablePanel() {
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Staff List");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setForeground(Kulay.CAVIAR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        String[] columns = {"Name", "Email", "Phone", "Department"};

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new CustomTable();
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBar(new CustomScrollBar());

        panel.add(title, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        loadSampleData();

        return panel;
    }

    private void loadSampleData() {
        staffData.clear();

        staffData.add(new Object[]{"Julia Santos", "juliasantos23@gmail.com", "0917-223-8812", "COECS"});
        staffData.add(new Object[]{"Miguel Torres", "miguel.torres11@gmail.com", "0995-887-4412", "CBEE"});
        staffData.add(new Object[]{"Hannah Cruz", "cruzhannah45@gmail.com", "0922-661-2348", "CAS"});
        staffData.add(new Object[]{"Patrick Ramos", "patramos88@gmail.com", "0934-782-1190", "CASTECH"});
        staffData.add(new Object[]{"Nina Delgado", "ninadelgado09@gmail.com", "0946-541-7788", "COECS"});
        staffData.add(new Object[]{"Gerald Yanez", "geraldyanez34@gmail.com", "0918-447-2205", "CBEE"});

        refreshTable();
    }

    private void searchStaff() {
        String keyword = searchField.getText().trim().toLowerCase();
        tableModel.setRowCount(0);

        for (Object[] row : staffData) {
            for (Object cell : row) {
                if (cell != null && cell.toString().toLowerCase().contains(keyword)) {
                    tableModel.addRow(row);
                    break;
                }
            }
        }
    }

    private void refreshTable() {
        searchField.setText("");
        tableModel.setRowCount(0);
        for (Object[] row : staffData) {
            tableModel.addRow(row);
        }
    }
}


