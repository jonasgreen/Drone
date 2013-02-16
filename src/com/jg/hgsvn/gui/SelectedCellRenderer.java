package com.jg.hgsvn.gui;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class SelectedCellRenderer extends DefaultListCellRenderer {
    private Color color;

    public SelectedCellRenderer(Color color) {
        this.color = color;
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (isSelected) {
            c.setBackground(color);
            c.setForeground(Color.BLACK);
        }
        return c;
    }
}

