/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.controller;

import studentinfo.util.Kulay;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class CustomTable extends JTable {
    
    public CustomTable() {
        super();
        customizeTable();
    }
    
    private void customizeTable() {
        
        setFont(new Font("Tahoma", Font.PLAIN, 13));
        setRowHeight(40);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setSelectionBackground(Kulay.LIGHT_GRAY);
        setSelectionForeground(Kulay.CHARCOAL_DARK);
        
        JTableHeader header = getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 13));
        header.setBackground(Kulay.CHARCOAL);
        header.setForeground(Kulay.CHARCOAL_DARK);
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 45));
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : Kulay.LIGHT_GRAY);
                }
                
                setForeground(Kulay.CAVIAR);
                setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                
                return c;
            }
        });
    }
}

}


