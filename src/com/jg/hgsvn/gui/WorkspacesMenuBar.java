package com.jg.hgsvn.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 */
public class WorkspacesMenuBar extends JPanel{

    private MainLeftPanel parent;

    public WorkspacesMenuBar(MainLeftPanel mainLeftPanel) {
        this.parent = mainLeftPanel;
        setLayout(new GridBagLayout());
        setBackground(Colors.menuBar);
        GridBagConstraints c = new GridBagConstraints();

        JButton plus = getPlusButton();

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
        c.insets = new Insets(4,4,2,36);
        
        c.anchor = GridBagConstraints.WEST;
        JLabel label = new JLabel("Workspaces");
        add(label, c);


    }

    private JButton getPlusButton() {
        JButton plus = new JButton("+");
        plus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setButtonSize(plus, Sizes.MENU_BUTTON_SIZE);
        plus.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent mouseEvent) {
                parent.addWorkspace();
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
                parent.deleteSelectedWorkspace();
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
