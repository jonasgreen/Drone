package com.jg.hgsvn.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 */
public class TemplateMenuBar extends JPanel{
    private MainLeftPanel parent;

    public TemplateMenuBar(MainLeftPanel parent) {
        this.parent = parent;
        setBackground(Colors.menuBar);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton plus = getPlus();
        setButtonSize(plus, Sizes.MENU_BUTTON_SIZE);

        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(4,4,4,2);
        add(plus, c);

        JButton minus = getMinusButton();
        setButtonSize(minus, Sizes.MENU_BUTTON_SIZE);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(4,2,4,2);
        add(minus, c);

        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        c.insets = new Insets(4,4,2,16);


        c.anchor = GridBagConstraints.WEST;
        JLabel label = new JLabel("Templates");
        add(label, c);


    }

    private JButton getPlus() {
        JButton plus = new JButton("+");
        plus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        plus.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent mouseEvent) {
                parent.addNewTemplate();
            }

            public void mousePressed(MouseEvent mouseEvent) {
                //TODO
            }

            public void mouseReleased(MouseEvent mouseEvent) {
                //TODO
            }

            public void mouseEntered(MouseEvent mouseEvent) {
                //TODO
            }

            public void mouseExited(MouseEvent mouseEvent) {
                //TODO
            }
        });
        return plus;
    }

    private JButton getMinusButton() {
        JButton minus = new JButton("-");
        minus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minus.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent mouseEvent) {
                parent.deleteSelected();
            }

            public void mousePressed(MouseEvent mouseEvent) {
                //TODO
            }

            public void mouseReleased(MouseEvent mouseEvent) {
                //TODO
            }

            public void mouseEntered(MouseEvent mouseEvent) {
                //TODO
            }

            public void mouseExited(MouseEvent mouseEvent) {
                //TODO
            }
        });
        return minus;
    }

    private void setButtonSize(JButton b, Dimension d) {
        b.setPreferredSize(d);
        b.setMaximumSize(d);
        b.setMinimumSize(d);
    }


}
