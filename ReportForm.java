/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.form;

/**
 *
 * @author Maine
 */
import studentinfo.controller.RoundPanel;
import studentinfo.util.Kulay;
import javax.swing.*;
import java.awt.*;

public class ReportForm extends JPanel {
    
    public ReportForm() {
        setLayout(new BorderLayout());
        setBackground(Kulay.VAPOROUS_GRAY);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        initComponents();
    }
    
    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);
        
        RoundPanel statsPanel = createStatsPanel();
        statsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 350));
        
        mainPanel.add(statsPanel);
        add(mainPanel, BorderLayout.NORTH);
    }
    
    private RoundPanel createStatsPanel() {
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel title = new JLabel("Statistics");
        title.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        title.setForeground(Kulay.CAVIAR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        JPanel statsGrid = new JPanel(new GridLayout(2, 2, 20, 20));
        statsGrid.setOpaque(false);
        
        statsGrid.add(createStatCard("Total Enrollment", "2,524", Kulay.CHARCOAL_DARK));
        statsGrid.add(createStatCard("Active Courses", "26", Kulay.CHARCOAL_DARK));
        statsGrid.add(createStatCard("Staff Members", "124", Kulay.CHARCOAL_DARK));
        
        panel.add(title, BorderLayout.NORTH);
        panel.add(statsGrid, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createStatCard(String label, String value, Color color) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(Kulay.LIGHT_GRAY);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Kulay.BORDER_DARK, 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        valueLabel.setForeground(color);
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelComponent.setForeground(Kulay.CAVIAR);
        labelComponent.setHorizontalAlignment(SwingConstants.CENTER);
        
        card.add(valueLabel, BorderLayout.CENTER);
        card.add(labelComponent, BorderLayout.SOUTH);
        
        return card;
    }
}
