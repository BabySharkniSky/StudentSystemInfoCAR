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
import studentinfo.util.Menulistener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

// SideMenu class - yung panel sa left na nagho-hold ng navigation buttons
// Nagdi-display ng menu items like Home, Students, Staff, Reports
public class SideMenu extends JPanel {

    private List<Menulistener> listeners = new ArrayList<>(); // List ng listeners para i-notify kapag may selection
    private List<JPanel> menuItems = new ArrayList<>();       // List ng menu panels
    private int selectedIndex = 0;                            // Current selected menu index
    private JLabel activeLabel = null;                        // Label ng active menu item

    public SideMenu() {
        setLayout(new BorderLayout());
        setBackground(Kulay.CHARCOAL_DARK);                  // Background ng side menu
        setPreferredSize(new Dimension(300, 0));             // Width ng side menu
        initComponents();                                    // Tawagin method para i-setup yung components
    }

    private void initComponents() {
        // STEP 1: Logo panel
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        logoPanel.setBackground(Kulay.CHARCOAL_DARK);
        JLabel logoLabel = new JLabel("SFIS");              // Logo text
        logoLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        logoLabel.setForeground(Kulay.WHITE);
        logoPanel.add(logoLabel);

        // STEP 2: Menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS)); // Vertical stacking ng menu items
        menuPanel.setBackground(Kulay.CHARCOAL_DARK);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Top padding

        String[] menus = {"Home", "Students", "Staff", "Reports"}; // Menu names

        // STEP 3: Create menu items
        for (int i = 0; i < menus.length; i++) {
            JPanel item = createMenuItem(menus[i], i);      // Gumawa ng menu panel
            menuItems.add(item);                            // Add sa list
            menuPanel.add(item);                            // Add sa menu panel
            menuPanel.add(Box.createRigidArea(new Dimension(0, 3))); // spacing between items
        }

        add(logoPanel, BorderLayout.NORTH);                // I-add logo sa top
        add(menuPanel, BorderLayout.CENTER);              // I-add menu sa center

        selectMenuItem(0); // Default selection sa Home
    }

    // Gumagawa ng bawat menu item panel
    private JPanel createMenuItem(String menuName, int index) {
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 12)); // Padding sa loob ng item
        item.setBackground(Kulay.CHARCOAL_DARK);
        item.setMaximumSize(new Dimension(250, 45));    // Max size ng panel
        item.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor kapag hover

        JLabel nameLabel = new JLabel(menuName);         // Label ng menu name
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameLabel.setForeground(Kulay.WHITE);
        item.add(nameLabel);

        // Rounded border effect para sa hover
        item.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Kulay.CHARCOAL_DARK));

        // Mouse events para sa click, hover, exit
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectMenuItem(index);    // I-select yung item kapag click
                setActiveLabel(nameLabel);
                notifyListeners(menuName); // I-notify yung listeners
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (index != selectedIndex) { // Kung hindi active, mag-change background on hover
                    item.setBackground(Kulay.CHARCOAL_LIGHT);
                    item.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Kulay.BLUE));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (index != selectedIndex) { // I-reset sa default kung hindi active
                    item.setBackground(Kulay.CHARCOAL_DARK);
                    item.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Kulay.CHARCOAL_DARK));
                }
            }
        });

        return item;
    }

    // Method para i-highlight yung selected menu item
    private void selectMenuItem(int index) {
        if (selectedIndex >= 0 && selectedIndex < menuItems.size()) {
            JPanel prev = menuItems.get(selectedIndex);   // Previous selected
            prev.setBackground(Kulay.CHARCOAL_DARK);
            prev.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Kulay.CHARCOAL_DARK));
        }
        selectedIndex = index;
        JPanel current = menuItems.get(index);           // Current selected
        current.setBackground(Kulay.CHARCOAL);
        current.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Kulay.GREEN)); // Active highlight
    }

    // Method para i-set bold yung active label
    private void setActiveLabel(JLabel label) {
        if (activeLabel != null) activeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        activeLabel = label;
    }

    // Para mag-add ng listener
    public void addMenuListener(Menulistener listener) {
        listeners.add(listener);
    }

    // I-notify lahat ng listeners kapag may menu na na-click
    private void notifyListeners(String menuName) {
        for (Menulistener listener : listeners) {
            listener.onMenuSelected(menuName);
        }
    }
}
