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
    private SideMenu sideMenu;   // Left side menu
    private topbar topBar;       // Top bar na nagdi-display ng title
    private dashboard dashboard; // Main panel kung saan nagpapalit yung forms

    // Constructor - tatawagin kapag gumawa ng Mainframe object
    public Mainframe() {
        setTitle("Student Information System");  // Title ng window
        setSize(1400, 800);                      // Window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app kapag pinindot 'X'
        setLocationRelativeTo(null);             // Center sa screen

        initComponents(); // Tawagin method para i-setup lahat ng components
    }

    // Method para i-initialize at i-layout lahat ng components
    private void initComponents() {
        setLayout(new BorderLayout()); // Gamitin BorderLayout sa frame

        // Instantiate components
        sideMenu = new SideMenu();
        topBar = new topbar();
        dashboard = new dashboard();

        // Add different forms sa dashboard
        dashboard.addForm("Home", new HomeForm());
        dashboard.addForm("Students", new StudentForm());
        dashboard.addForm("Staff", new StaffForm());
        dashboard.addForm("Reports", new ReportForm());

        // Add listener sa side menu - kapag pinili ng user ang menu
        sideMenu.addMenuListener(menuName -> {
            dashboard.showForm(menuName); // Show corresponding form
            topBar.setTitle(menuName);    // Update title sa top bar
        });

        // Main panel para sa top bar at dashboard
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topBar, BorderLayout.NORTH);   // Top bar sa taas
        mainPanel.add(dashboard, BorderLayout.CENTER); // Dashboard sa gitna

        // Add panels sa frame
        add(sideMenu, BorderLayout.WEST);      // Side menu sa left
        add(mainPanel, BorderLayout.CENTER);   // Main panel sa center
    }

    // Main method - starting point ng app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // Ensure thread-safe sa GUI
            Mainframe frame = new Mainframe();
            frame.setVisible(true); // Ipakita ang frame
        });
    }
}
