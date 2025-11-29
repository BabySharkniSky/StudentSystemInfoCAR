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

// Ito yung StaffForm, para sa Staff management page ng system
// Dito pwedeng mag-view at mag-search ng staff records
// Read-only lang ito, walang add/edit/delete features
public class StaffForm extends JPanel {
    
    // UI Components
    private CustomTable table;              // Table para ipakita yung staff list
    private DefaultTableModel tableModel;   // Data model ng table
    private JTextField searchField;         // Search input field
    
    // In-memory storage ng staff data
    private List<Object[]> staffData = new ArrayList<>();

    // Constructor - dito ine-setup ang layout at components
    public StaffForm() {
        setLayout(new BorderLayout());              // Main layout ng form
        setBackground(Kulay.VAPOROUS_GRAY);        // Background color
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Padding sa paligid
        initComponents();                           // Initialize UI components
    }

    // Method para i-setup ang components sa form
    private void initComponents() {
        // Main panel para contain ang top controls at table
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setOpaque(false);

        // Top panel para sa search controls
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        topPanel.setOpaque(false);

        // Search input field
        searchField = new JTextField(20);
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchField.setForeground(Kulay.CAVIAR);
        searchField.setPreferredSize(new Dimension(250, 35)); 
        searchField.setBorder(BorderFactory.createLineBorder(Kulay.BORDER_NEUTRAL, 2));

        // Search button
        CustomButton searchButton = new CustomButton("Search");
        searchButton.setPreferredSize(new Dimension(120, 40));
        searchButton.addActionListener(e -> searchStaff());  // Action kapag nag-click search
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchButton.setBackground(Kulay.BLUE);
        searchButton.setForeground(Kulay.WHITE);

        // Refresh button
        CustomButton refreshButton = new CustomButton("Refresh");
        refreshButton.setPreferredSize(new Dimension(120, 40));
        refreshButton.addActionListener(e -> refreshTable()); // Action kapag nag-click refresh
        refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

        // Add controls sa top panel
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(refreshButton);

        // Table panel na nagdi-display ng staff list
        RoundPanel tablePanel = createTablePanel();

        // Add panels sa main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        // Add main panel sa form
        add(mainPanel, BorderLayout.CENTER);
    }

    // Method para gumawa ng table panel na may title at scrollable table
    private RoundPanel createTablePanel() {
        RoundPanel panel = new RoundPanel();          // Rounded panel
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title label ng panel
        JLabel title = new JLabel("Staff List");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setForeground(Kulay.CAVIAR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Column names para sa table
        String[] columns = {"Name", "Email", "Phone", "Department"};

        // Table model - read-only
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hindi pwedeng i-edit yung cells
            }
        };

        // Create custom table at set model
        table = new CustomTable();
        table.setModel(tableModel);

        // Scroll pane para sa table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBar(new CustomScrollBar());

        // Add components sa panel
        panel.add(title, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Load sample staff data
        loadSampleData();

        return panel;
    }

    // for Load sample data sa table, kunyare nalang may staff tayong mga ganito
    private void loadSampleData() {
        staffData.clear(); // Clear old data

        // Sample staff records
        staffData.add(new Object[]{"Julia Santos", "juliasantos23@gmail.com", "0917-223-8812", "COECS"});
        staffData.add(new Object[]{"Miguel Torres", "miguel.torres11@gmail.com", "0995-887-4412", "CBEE"});
        staffData.add(new Object[]{"Hannah Cruz", "cruzhannah45@gmail.com", "0922-661-2348", "CAS"});
        staffData.add(new Object[]{"Patrick Ramos", "patramos88@gmail.com", "0934-782-1190", "CASTECH"});
        staffData.add(new Object[]{"Nina Delgado", "ninadelgado09@gmail.com", "0946-541-7788", "COECS"});
        staffData.add(new Object[]{"Gerald Yanez", "geraldyanez34@gmail.com", "0918-447-2205", "CBEE"});

        // Refresh table para makita agad
        refreshTable();
    }

    // Search method - i-filter ang table based sa keyword
    private void searchStaff() {
        String keyword = searchField.getText().trim().toLowerCase(); // Get keyword
        tableModel.setRowCount(0); // Clear table

        // Loop sa staff data
        for (Object[] row : staffData) {
            for (Object cell : row) {
                if (cell != null && cell.toString().toLowerCase().contains(keyword)) {
                    tableModel.addRow(row); // Add row kung match
                    break; // Stop checking other cells
                }
            }
        }
    }

    // Refresh method - ipakita lahat ng data sa table
    private void refreshTable() {
        searchField.setText("");      // Clear search input
        tableModel.setRowCount(0);    // Clear table
        for (Object[] row : staffData) {
            tableModel.addRow(row);   // Add lahat ng data
        }
    }
}
