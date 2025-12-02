/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.ui;

/**
 *
 * @author Maine
 */
import studentinfo.form.*;
import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {

    // Components ng main frame
    private SideMenu sideMenu;   
    private topbar topBar;      
    private dashboard dashboard; 

    // Constructor 
    public Mainframe() {
        setTitle("Student Information System");  
        setSize(1400, 800);                     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);             

        initComponents(); 
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        sideMenu = new SideMenu();
        topBar = new topbar();
        dashboard = new dashboard();

  
        dashboard.addForm("Home", new HomeForm());
        dashboard.addForm("Students", new StudentForm());
        dashboard.addForm("Staff", new StaffForm());
        dashboard.addForm("Reports", new ReportForm());

       
        sideMenu.addMenuListener(menuName -> {
            dashboard.showForm(menuName); 
            topBar.setTitle(menuName);    
        });

       
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topBar, BorderLayout.NORTH);  
        mainPanel.add(dashboard, BorderLayout.CENTER); 

        // Add panels sa frame
        add(sideMenu, BorderLayout.WEST);      
        add(mainPanel, BorderLayout.CENTER);   
    }

  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { 
            Mainframe frame = new Mainframe();
            frame.setVisible(true); 
        });
    }
}

