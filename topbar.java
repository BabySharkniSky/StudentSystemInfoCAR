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

// TopBar class - yung horizontal bar sa taas ng dashboard
// Nagdi-display ng title ng current page/form
public class topbar extends JPanel {

    private JLabel titleLabel; // Label para sa title ng page

    public topbar() {
        // STEP 1: Layout at basic settings
        setLayout(new BorderLayout());                     // Simple left-right layout
        setBackground(Color.WHITE);                        // Background color
        setPreferredSize(new Dimension(0, 60));           // Height lang ang fixed, width flexible

        // STEP 2: Bottom border
        // Para may line effect sa ilalim ng topbar
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Kulay.BORDER_NEUTRAL));

        // STEP 3: Initialize components
        initComponents();
    }

    private void initComponents() {
        // STEP 3a: Create title label
        titleLabel = new JLabel("Homepage");              // Default text
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16)); // Bold at medyo large font
        titleLabel.setForeground(Kulay.CAVIAR);          // Dark color para readable
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0)); // Left padding

        // STEP 3b: Add label sa panel
        add(titleLabel, BorderLayout.WEST);               // I-align sa left
    }

    // STEP 4: Public method para i-update yung title dynamically
    public void setTitle(String title) {
        titleLabel.setText(title);                        // Palitan lang yung text
    }
}
