/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.ui;

/**
 *
 * @author Maine
 */

import studentinfo.util.Kulay;
import javax.swing.*;
import java.awt.*;


public class topbar extends JPanel {

    private JLabel titleLabel; 

    public topbar() {
     
        setLayout(new BorderLayout());                     
        setBackground(Color.WHITE);                     
        setPreferredSize(new Dimension(0, 60));          

   

        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Kulay.BORDER_NEUTRAL));

   
        initComponents();
    }

    private void initComponents() {

        titleLabel = new JLabel("Homepage");             
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16)); 
        titleLabel.setForeground(Kulay.CAVIAR);        
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0)); 

        add(titleLabel, BorderLayout.WEST);           
    }

    public void setTitle(String title) {
        titleLabel.setText(title);                    
    }
}


