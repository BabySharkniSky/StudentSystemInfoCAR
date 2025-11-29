/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.ui;

/**
 *
 * @author Maine
 */
import studentinfo.controller.CustomScrollBar;
import studentinfo.util.Kulay;
import javax.swing.*;
import java.awt.*;

// Dashboard class - ito yung main content area ng app
// Dito natin dinidisplay lahat ng forms: Home, Students, Staff, Reports
// Gumagamit ng CardLayout para mag-switch ng forms
public class dashboard extends JPanel {
    
    // Private fields
    private JPanel contentPanel;  // Panel kung saan ilalagay lahat ng forms
    private CardLayout cardLayout; // Layout manager na parang deck of cards, isa lang visible sa isang time
    
    // Constructor - i-initialize ang dashboard
    public dashboard() {
        setLayout(new BorderLayout());           // BorderLayout para isa lang malaking area
        setBackground(Kulay.VAPOROUS_GRAY);      // Background color ng dashboard
        initComponents();                         // Tawagin method para i-setup components
    }
    
    // Method para i-setup lahat ng components ng dashboard
    private void initComponents() {
        // STEP 1: Gumawa ng CardLayout
        // Isa lang visible sa isang time, pero pwede mag-switch
        cardLayout = new CardLayout();
        
        // STEP 2: Gumawa ng content panel gamit ang CardLayout
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(Kulay.VAPOROUS_GRAY); // Set background
        
        // STEP 3: I-wrap sa JScrollPane para may scroll capability
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);                        // Remove default border
        scrollPane.setVerticalScrollBar(new CustomScrollBar()); // Custom vertical scrollbar
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Scroll speed, mas smooth
        
        // STEP 4: Add scroll pane sa center ng dashboard
        add(scrollPane, BorderLayout.CENTER);
    }
    
    // Public method para mag-add ng form sa dashboard
    // name = identifier ng form, form = actual JPanel
    public void addForm(String name, JPanel form) {
        contentPanel.add(form, name); // I-register yung form sa content panel gamit name
    }
    
    // Public method para mag-show ng specific form sa dashboard
    // name = name ng form na gusto i-display
    public void showForm(String name) {
        cardLayout.show(contentPanel, name); // Ipakita yung form at i-hide ang iba
    }
}
