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


public class dashboard extends JPanel {
    
    private JPanel contentPanel; 
    private CardLayout cardLayout; 
    
    
    public dashboard() {
        setLayout(new BorderLayout());           
        setBackground(Kulay.VAPOROUS_GRAY);     
        initComponents();                       
    }
    
    private void initComponents() {
        cardLayout = new CardLayout();
        
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(Kulay.VAPOROUS_GRAY); 
        
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);                       
        scrollPane.setVerticalScrollBar(new CustomScrollBar()); 
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); 
        
      
        add(scrollPane, BorderLayout.CENTER);
    }
    
    public void addForm(String name, JPanel form) {
        contentPanel.add(form, name); 
    }
    
    public void showForm(String name) {
        cardLayout.show(contentPanel, name);
    }
}

