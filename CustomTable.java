/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.controller;

/**
 *
 * @author Maine
 */

import studentinfo.util.Kulay;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

// Ito yung CustomTable class na gagamitin natin pag gusto nating 
// may sariling style yung table sa system. 
// Mas maganda kasi tignan kaysa sa default look ng JTable.
public class CustomTable extends JTable {
    
    // Constructor ng class — tawag agad pag gumawa ka ng bagong CustomTable.
    public CustomTable() {
        super(); // tawag muna sa constructor ng JTable
        
        // After gumawa ng table object, i-apply natin agad yung design.
        customizeTable();
    }
    
    // Dito natin nilalagay lahat ng design at formatting para sa table.
    private void customizeTable() {
        
        // Set ng font sa mga cell ng table para uniform ang itsura.
        setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        // Gawing mas mataas ang bawat row para hindi dikit-dikit ang text.
        setRowHeight(40);
        
        // Hide yung grid lines para mas malinis tignan.
        setShowGrid(false);
        
        // Walang spacing sa pagitan ng cells.
        setIntercellSpacing(new Dimension(0, 0));
        
        // Kulay ng background kapag naka-select ang row.
        setSelectionBackground(Kulay.LIGHT_GRAY);
        
        // Kulay ng text kapag naka-select ang row.
        setSelectionForeground(Kulay.CHARCOAL_DARK);
        
        // Kukunin natin yung header para ma-apply yung design.
        JTableHeader header = getTableHeader();
        
        // Palitan yung font ng header para mas bold at mas halata.
        header.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        // Background color ng header.
        header.setBackground(Kulay.CHARCOAL);
        
        // Text color ng header.
        header.setForeground(Kulay.CHARCOAL_DARK);
        
        // Gawing mas mataas ang header para mas readable.
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 45));
        
        // Custom renderer para kontrolado natin kung paano lumalabas ang cells.
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                
                // Tawagin muna yung default rendering.
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                // Kung hindi selected ang row, lagyan ng alternating color effect.
                if (!isSelected) {
                    // Para mas madaling basahin, palitan yung kulay kada row
                    c.setBackground(row % 2 == 0 ? Color.WHITE : Kulay.LIGHT_GRAY);
                }
                
                // Kulay ng text sa cells.
                setForeground(Kulay.CAVIAR);
                
                // Maglagay ng konting padding sa loob ng cell.
                setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                
                return c;
            }
        });
    }
}

