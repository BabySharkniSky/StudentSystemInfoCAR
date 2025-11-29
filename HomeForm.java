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
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeForm extends JPanel {
    private JLabel timeLabel;

    public HomeForm() {
        // Ginamitan natin ng BorderLayout na may konting spacing para breathable tingnan
        setLayout(new BorderLayout(15, 15));

        // Simple, malinis na white background
        setBackground(Kulay.WHITE);

        // Padding ng buong panel para hindi dikit sa edges yung contents
        setBorder(new EmptyBorder(30, 30, 30, 30));

        initComponents();
        startClock(); // Tawagin agad yung clock para mag-display ng date/time
    }

    private void initComponents() {
        // Header (greetings + date)
        add(createHeaderPanel(), BorderLayout.NORTH);

        // Top stats cards (Students, Staff, Courses)
        add(createTopCardsPanel(), BorderLayout.CENTER);

        // Bottom section placeholder (future content)
        add(createBottomPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(true);
        panel.setBackground(Kulay.ACCENT_GRAY);

        // Space sa baba para hindi dikit sa ibang components
        panel.setBorder(new EmptyBorder(0, 0, 15, 0));

        // Container ng welcome text at subtitle
        JPanel welcomePanel = new JPanel(new GridLayout(2, 1, 0, 3));
        welcomePanel.setOpaque(false);

        JLabel welcome = new JLabel("Hi there, Basta!");
        welcome.setFont(new Font("Tahoma", Font.BOLD, 22));
        welcome.setForeground(Color.BLACK);

        JLabel subtitle = new JLabel("Today's Updates");
        subtitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
        subtitle.setForeground(Color.BLACK);

        welcomePanel.add(welcome);
        welcomePanel.add(subtitle);

        // Label kung saan lalagay ang current date
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        timeLabel.setForeground(Color.BLACK);

        // Arrange left (welcome) at right (date/time)
        panel.add(welcomePanel, BorderLayout.WEST);
        panel.add(timeLabel, BorderLayout.EAST);

        return panel;
    }


    private JPanel createTopCardsPanel() {
    JPanel grid = new JPanel(new GridLayout(1, 4, 5, 0));
    grid.setOpaque(false);

    String[][] cards = {
        {"Total Students", "2,524", "INFO"},
        {"Total Staff", "124", "SUCCESS"},
        {"Courses", "26", "WARNING"},
    };

    for (String[] data : cards) {
        grid.add(createInfoCard(data[0], data[1], Kulay.getColor(data[2])));
    }

    return grid;
}

    private JPanel createInfoCard(String label, String value, Color color) {
        RoundPanel card = new RoundPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Kulay.BORDER_NEUTRAL, 2));
        card.setOpaque(true);

    // VALUE (big number)
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        valueLabel.setForeground(color);
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER); // ginamiit to para ma center yung content nung nasa box

    // TEXT LABEL (Total Students, etc.)
        JLabel nameLabel = new JLabel(label);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER); // ginamit to para ma center yung content nung nasa box

    // CENTERING BOTH
        JPanel textPanel = new JPanel(new GridLayout(2, 1, 0, 3));
        textPanel.setOpaque(false);
        textPanel.add(valueLabel);
        textPanel.add(nameLabel);

        card.add(textPanel, BorderLayout.CENTER);

       return card;
    }

    private JPanel createBottomPanel() {
        // Placeholder area sa baba para may space
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
        panel.setOpaque(false);

        // Placeholder height para may structure
        panel.setPreferredSize(new Dimension(0, 350));

        return panel;
    }

    private void startClock() {
        // Kukunin lang natin yung current date (fixed for now)
        String time = new SimpleDateFormat("EEEE, MMM dd, yyyy").format(new Date());

        timeLabel.setText(time);
        timeLabel.setForeground(Color.BLACK);
    }
}

