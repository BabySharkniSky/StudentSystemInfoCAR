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

public class SideMenu extends JPanel {

    private List<Menulistener> listeners = new ArrayList<>(); 
    private List<JPanel> menuItems = new ArrayList<>();      
    private int selectedIndex = 0;                            
    private JLabel activeLabel = null;                       

    public SideMenu() {
        setLayout(new BorderLayout());
        setBackground(Kulay.CHARCOAL_DARK);                 
        setPreferredSize(new Dimension(300, 0));             
        initComponents();                                   
    }

    private void initComponents() {
      
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        logoPanel.setBackground(Kulay.CHARCOAL_DARK);
        JLabel logoLabel = new JLabel("SFIS");              
        logoLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        logoLabel.setForeground(Kulay.WHITE);
        logoPanel.add(logoLabel);

     
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS)); 
        menuPanel.setBackground(Kulay.CHARCOAL_DARK);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); 

        String[] menus = {"Home", "Students", "Staff", "Reports"}; 

        // STEP 3: Create menu items
        for (int i = 0; i < menus.length; i++) {
            JPanel item = createMenuItem(menus[i], i);      
            menuItems.add(item);                           
            menuPanel.add(item);                           
            menuPanel.add(Box.createRigidArea(new Dimension(0, 3))); 
        }

        add(logoPanel, BorderLayout.NORTH);               
        add(menuPanel, BorderLayout.CENTER);              

        selectMenuItem(0);
    }


    private JPanel createMenuItem(String menuName, int index) {
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 12)); 
        item.setBackground(Kulay.CHARCOAL_DARK);
        item.setMaximumSize(new Dimension(250, 45));    
        item.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

        JLabel nameLabel = new JLabel(menuName);         
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameLabel.setForeground(Kulay.WHITE);
        item.add(nameLabel);

        item.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Kulay.CHARCOAL_DARK));

  
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectMenuItem(index);    
                setActiveLabel(nameLabel);
                notifyListeners(menuName); 
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (index != selectedIndex) { 
                    item.setBackground(Kulay.CHARCOAL_LIGHT);
                    item.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Kulay.BLUE));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (index != selectedIndex) { 
                    item.setBackground(Kulay.CHARCOAL_DARK);
                    item.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Kulay.CHARCOAL_DARK));
                }
            }
        });

        return item;
    }


    private void selectMenuItem(int index) {
        if (selectedIndex >= 0 && selectedIndex < menuItems.size()) {
            JPanel prev = menuItems.get(selectedIndex);  
            prev.setBackground(Kulay.CHARCOAL_DARK);
            prev.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Kulay.CHARCOAL_DARK));
        }
        selectedIndex = index;
        JPanel current = menuItems.get(index);          
        current.setBackground(Kulay.CHARCOAL);
        current.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Kulay.GREEN)); 
    }

    private void setActiveLabel(JLabel label) {
        if (activeLabel != null) activeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        activeLabel = label;
    }

    public void addMenuListener(Menulistener listener) {
        listeners.add(listener);
    }

    private void notifyListeners(String menuName) {
        for (Menulistener listener : listeners) {
            listener.onMenuSelected(menuName);
        }
    }
}
