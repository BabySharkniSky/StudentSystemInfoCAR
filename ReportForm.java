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

// Ito yung ReportForm class natin, parang dashboard na nagdi-display ng quick stats
// Ginagamit natin ito para makita agad yung key numbers ng system sa visual cards
public class ReportForm extends JPanel {
    
    // Constructor ng form, dito natin ine-setup yung layout at components
    public ReportForm() {
        // I-set yung layout to BorderLayout para mas madali i-place yung sections (top, center, bottom)
        setLayout(new BorderLayout());
        
        // Background color ng form, vaporous gray para hindi sobrang plain white
        setBackground(Kulay.VAPOROUS_GRAY);
        
        // Padding sa paligid ng buong form para hindi dikit sa edges yung components
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Tawagin method para i-initialize lahat ng UI components
        initComponents();
    }
    
    // Method para i-setup at i-add ang lahat ng components sa form
    private void initComponents() {
        // Main panel na gagamitin para i-contain lahat ng sections
        JPanel mainPanel = new JPanel();
        
        // Vertical layout para ang cards ay stacked from top to bottom
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        // Transparent para makita yung background color ng form sa likod
        mainPanel.setOpaque(false);
        
        // Gumawa ng stats panel, dito lalagay yung mga rounded cards na nagdi-display ng numbers
        RoundPanel statsPanel = createStatsPanel();
        
        // Limit ang height para consistent at hindi lumaki masyado, width ay flexible
        statsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 350));
        
        // I-add yung stats panel sa main panel
        mainPanel.add(statsPanel);
        
        // I-add ang main panel sa top section ng form (BorderLayout.NORTH)
        add(mainPanel, BorderLayout.NORTH);
    }
    
    // Method na gumagawa ng panel na may statistics cards
    private RoundPanel createStatsPanel() {
        // Rounded panel para mas smooth ang edges
        RoundPanel panel = new RoundPanel();
        
        // White background para malinaw yung cards
        panel.setBackground(Color.WHITE);
        
        // BorderLayout para may space sa top (title) at center (cards)
        panel.setLayout(new BorderLayout());
        
        // Padding sa loob para hindi dikit yung content sa edges
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Title label ng stats section
        JLabel title = new JLabel("Statistics");
        title.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18)); // Bold + Italic para standout
        title.setForeground(Kulay.CAVIAR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); // Space sa ilalim ng title
        
        // Panel na nagco-contain ng stat cards, 2 rows x 2 columns
        JPanel statsGrid = new JPanel(new GridLayout(2, 2, 20, 20)); // 20px gap sa pagitan ng cards
        statsGrid.setOpaque(false); // Transparent para makita yung panel background
        
        // Add individual stat cards
        statsGrid.add(createStatCard("Total Enrollment", "2,524", Kulay.CHARCOAL_DARK));
        statsGrid.add(createStatCard("Active Courses", "26", Kulay.CHARCOAL_DARK));
        statsGrid.add(createStatCard("Staff Members", "124", Kulay.CHARCOAL_DARK));
        
        // Add title sa top, stats grid sa center ng rounded panel
        panel.add(title, BorderLayout.NORTH);
        panel.add(statsGrid, BorderLayout.CENTER);
        
        return panel;
    }
    
    // Method para gumawa ng individual statistic card
    // label = description, value = number, color = accent ng number
    private JPanel createStatCard(String label, String value, Color color) {
        // Panel ng card, may space sa pagitan ng value at label
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(Kulay.LIGHT_GRAY); // Light gray background para hindi stark white
        
        // Compound border: outer line border + inner padding
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Kulay.BORDER_DARK, 1), // 1px dark line sa labas
            BorderFactory.createEmptyBorder(20, 20, 20, 20) // Padding sa loob ng card
        ));
        
        // Label para sa value ng stat, malaking font para main focus
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        valueLabel.setForeground(color);
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centered
        
        // Label para sa description ng stat
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelComponent.setForeground(Kulay.CAVIAR);
        labelComponent.setHorizontalAlignment(SwingConstants.CENTER); // Centered
        
        // Add value sa center, label sa bottom ng card
        card.add(valueLabel, BorderLayout.CENTER);
        card.add(labelComponent, BorderLayout.SOUTH);
        
        return card;
    }
}
