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


public class infocard extends RoundPanel {
    
    // Private fields
    private CardData data;       
    private JLabel titleLabel; 
    private JLabel valueLabel;   
   
    public infocard(CardData data) {
        this.data = data;
        
        setLayout(new BorderLayout(10, 10));        
        setBackground(Color.WHITE);                   
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        
        initComponents(); 
    }
    

    private void initComponents() {
      
        JPanel textPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        textPanel.setOpaque(false);
        
  
        titleLabel = new JLabel(data.getTitle());  
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));   
        titleLabel.setForeground(new Color(120, 120, 120));       
        
        valueLabel = new JLabel(data.getValue());    
        valueLabel.setFont(new Font("Tahoma", Font.BOLD, 28));    
        valueLabel.setForeground(new Color(85, 85, 85));          
        
        textPanel.add(titleLabel);
        textPanel.add(valueLabel);
     
        add(textPanel, BorderLayout.CENTER); 
    }
    
    public void updateValue(String value) {
        valueLabel.setText(value); 
    }
}
