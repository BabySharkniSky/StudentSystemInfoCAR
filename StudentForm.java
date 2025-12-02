/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.form;

import studentinfo.controller.*;
import studentinfo.util.Kulay;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class StudentForm extends JPanel {

    private CustomTable table;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    
    private JTextField idField, nameField, emailField, phoneField, courseField;
    private JComboBox<String> statusBox; 
    
    // Data storage
    private List<Object[]> studentData = new ArrayList<>();
    
    /**
     * Constructor - Dito ine-setup ang layout, background, at padding
     */
    public StudentForm() {
        setLayout(new BorderLayout());
        setBackground(Kulay.VAPOROUS_GRAY);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        initComponents();
    }
    
   
 
    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setOpaque(false);

        RoundPanel formPanel = createFormPanel(); 
        
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        searchPanel.setOpaque(false);

        searchField = new JTextField(20);
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchField.setBorder(BorderFactory.createLineBorder(Kulay.BORDER_NEUTRAL, 2));
        searchField.setPreferredSize(new Dimension(250, 35));

        CustomButton searchButton = new CustomButton("Search");
        searchButton.setPreferredSize(new Dimension(120, 50));
        searchButton.addActionListener(e -> searchStudent());
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        searchButton.setBackground(Kulay.BLUE);
        searchButton.setForeground(Color.white);

        CustomButton refreshButton = new CustomButton("Refresh");
        refreshButton.setPreferredSize(new Dimension(120, 50));
        refreshButton.addActionListener(e -> refreshTable());
        refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        refreshButton.setBackground(Kulay.GREEN);
        refreshButton.setForeground(Color.WHITE);

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(refreshButton);

        RoundPanel tablePanel = createTablePanel(); 

        // Top section - form + search panel
        JPanel topSection = new JPanel(new BorderLayout(0, 20));
        topSection.setOpaque(false);
        topSection.add(formPanel, BorderLayout.NORTH);
        topSection.add(searchPanel, BorderLayout.SOUTH);

        mainPanel.add(topSection, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);
    }
    

    private RoundPanel createFormPanel() {
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout(0, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Information of Students");
        title.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        title.setForeground(Kulay.CAVIAR);

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 3, 15, 15));
        fieldsPanel.setOpaque(false);

 
        idField = new JTextField(); nameField = new JTextField(); emailField = new JTextField();
        phoneField = new JTextField(); courseField = new JTextField();
        for (JTextField f : new JTextField[]{idField,nameField,emailField,phoneField,courseField}) {
            f.setFont(new Font("Tahoma", Font.PLAIN, 14));
            f.setForeground(Kulay.CAVIAR);
        }

        fieldsPanel.add(createFieldPanel("Student ID:", idField));
        fieldsPanel.add(createFieldPanel("Full Name:", nameField));
        fieldsPanel.add(createFieldPanel("Email:", emailField));
        fieldsPanel.add(createFieldPanel("Phone:", phoneField));
        fieldsPanel.add(createFieldPanel("Course:", courseField));

    
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        buttonsPanel.setOpaque(false);

        CustomButton addButton = new CustomButton("Add Student"); addButton.setPreferredSize(new Dimension(130, 40)); addButton.addActionListener(e -> addStudent()); addButton.setBackground(Kulay.CHARCOAL_DARK); addButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        CustomButton updateButton = new CustomButton("Update"); updateButton.setPreferredSize(new Dimension(130, 40)); updateButton.addActionListener(e -> updateStudent()); updateButton.setBackground(Kulay.CHARCOAL_DARK); updateButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        CustomButton deleteButton = new CustomButton("Delete"); deleteButton.setPreferredSize(new Dimension(130, 40)); deleteButton.addActionListener(e -> deleteStudent()); deleteButton.setBackground(Kulay.RED); deleteButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        CustomButton clearButton = new CustomButton("Clear"); clearButton.setPreferredSize(new Dimension(130, 40)); clearButton.addActionListener(e -> clearFields()); clearButton.setBackground(Kulay.CHARCOAL_DARK); clearButton.setFont(new Font("Tahoma", Font.BOLD, 12));

        buttonsPanel.add(clearButton); buttonsPanel.add(deleteButton); buttonsPanel.add(updateButton); buttonsPanel.add(addButton);

        panel.add(title, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        return panel;
    }
    
    private JPanel createFieldPanel(String label, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout(0, 5));
        panel.setOpaque(false);
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Tahoma", Font.PLAIN, 12));
        labelComponent.setForeground(Kulay.CAVIAR);
        panel.add(labelComponent, BorderLayout.NORTH);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }
    

    private RoundPanel createTablePanel() {
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("List Of Students");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setForeground(Kulay.CAVIAR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        String[] columns = {"ID", "Name", "Email", "Phone", "Course"};

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        table = new CustomTable();
        table.setModel(tableModel);
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) loadStudentToForm(table.getSelectedRow());
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBar(new CustomScrollBar());

        panel.add(title, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        loadSampleData(); 

        return panel;
    }

    private void loadSampleData() {
        studentData.clear();

        studentData.add(new Object[]{"C2025123401", "Aira Mendoza", "aira.mendoza@gmail.com", "0917-234-5678", "Information Technology", "Active"});
        studentData.add(new Object[]{"C2025789044", "Mark dela Cruz", "markdelacruz20@yahoo.com", "0928-556-7834", "Computer Engineering", "Active"});
        studentData.add(new Object[]{"C2025456782", "Janna Corpuz", "corpuzjanna@gmail.com", "0956-892-1123", "Hospitality Management", "Inactive"});
        studentData.add(new Object[]{"C2025342199", "Ethan Navarro", "ethannavarrro@gmail.com", "0945-101-9987", "Business Administration", "Graduated"});
        studentData.add(new Object[]{"C2025338019", "Ralph Domingo", "ralphdomingo12@gmail.com", "0916-403-2229", "Civil Engineering", "Active"});
        studentData.add(new Object[]{"C2025998740", "Lynne Soriano", "lsoriano@gmail.com", "0923-120-7789", "Education Major in English", "Active"});

        refreshTable();
    }

    private void loadStudentToForm(int row) {
        idField.setText(tableModel.getValueAt(row, 0).toString());
        nameField.setText(tableModel.getValueAt(row, 1).toString());
        emailField.setText(tableModel.getValueAt(row, 2).toString());
        phoneField.setText(tableModel.getValueAt(row, 3).toString());
        courseField.setText(tableModel.getValueAt(row, 4).toString());
    }

    private void addStudent() {
        if (validateFields()) {
            Object[] newStudent = {idField.getText(), nameField.getText(), emailField.getText(), phoneField.getText(), courseField.getText()};
            studentData.add(newStudent);
            tableModel.addRow(newStudent);
            clearFields();
            JOptionPane.showMessageDialog(this, "Added successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) { JOptionPane.showMessageDialog(this, "Please select a student to update!", "Warning", JOptionPane.WARNING_MESSAGE); return; }
        if (validateFields()) {
            Object[] updatedStudent = {idField.getText(), nameField.getText(), emailField.getText(), phoneField.getText(), courseField.getText()};
            studentData.set(selectedRow, updatedStudent);
            for (int i = 0; i < updatedStudent.length; i++) tableModel.setValueAt(updatedStudent[i], selectedRow, i);
            clearFields();
            JOptionPane.showMessageDialog(this, "Updated successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) { JOptionPane.showMessageDialog(this, "Please select a student to delete!", "Warning", JOptionPane.WARNING_MESSAGE); return; }
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            studentData.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            clearFields();
            JOptionPane.showMessageDialog(this, "Deleted successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void searchStudent() {
        String keyword = searchField.getText().trim().toLowerCase();
        tableModel.setRowCount(0);
        for (Object[] row : studentData) for (Object cell : row) if (cell != null && cell.toString().toLowerCase().contains(keyword)) { tableModel.addRow(row); break; }
    }

    private void refreshTable() {
        searchField.setText("");
        tableModel.setRowCount(0);
        for (Object[] row : studentData) tableModel.addRow(row);
    }

    private void clearFields() {
        idField.setText(""); nameField.setText(""); emailField.setText(""); phoneField.setText(""); courseField.setText("");
        table.clearSelection();
    }

    private boolean validateFields() {
        if (idField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty() ||
            emailField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty() ||
            courseField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
