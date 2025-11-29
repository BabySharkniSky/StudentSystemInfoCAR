/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.ui;

/**
 *
 * @author Maine
 */
import studentinfo.controller.RoundPanel;
import studentinfo.model.CardData;
import javax.swing.*;
import java.awt.*;

// InfoCard class - yung mga maliit na cards sa dashboard
// Nagdi-display ng statistics tulad ng "Total Students: 1,245"
// Nag-extend sa RoundPanel para may rounded corners
public class infocard extends RoundPanel {
    
    // Private fields
    private CardData data;       // Yung data na ipapakita sa card
    private JLabel titleLabel;   // Label para sa title ng card
    private JLabel valueLabel;   // Label para sa numerical value
    
    // Constructor - tatanggap ng CardData object
    public infocard(CardData data) {
        this.data = data; // I-save yung data
        
        setLayout(new BorderLayout(10, 10));          // Layout with 10px gaps
        setBackground(Color.WHITE);                   // Background color white
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding 20px
        
        initComponents(); // Tawagin method para i-setup components
    }
    
    // Method para gumawa ng labels at ilagay sa card
    private void initComponents() {
        // STEP 1: Gumawa ng panel para sa text labels
        JPanel textPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        textPanel.setOpaque(false); // Transparent para lumabas background ng card
        
        // STEP 2: Create title label
        titleLabel = new JLabel(data.getTitle());    // Kunin title from CardData
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));   // Font plain, size 14
        titleLabel.setForeground(new Color(120, 120, 120));       // Gray color para secondary info
        
        // STEP 3: Create value label
        valueLabel = new JLabel(data.getValue());    // Kunin value from CardData
        valueLabel.setFont(new Font("Tahoma", Font.BOLD, 28));    // Bold at malaki, size 28
        valueLabel.setForeground(new Color(85, 85, 85));          // Dark gray color para main focus
        
        // STEP 4: Add labels sa text panel
        textPanel.add(titleLabel);
        textPanel.add(valueLabel);
        
        // STEP 5: Add text panel sa card
        add(textPanel, BorderLayout.CENTER); // Ilagay sa gitna ng card
    }
    
    // Public method para i-update ang value sa card
    // Useful kung nagbabago yung data real-time
    public void updateValue(String value) {
        valueLabel.setText(value); // I-update lang yung label
    }
}
