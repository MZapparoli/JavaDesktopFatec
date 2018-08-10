/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Matheus
 */
public class TableCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        // operador ternário
        /*component.setBackground(isSelected ? 
                Color.WHITE : 
                (row % 2 == 0) ? 
                        Color.WHITE : 
                        Color.LIGHT_GRAY);*/
        return component;
    }
    
}
