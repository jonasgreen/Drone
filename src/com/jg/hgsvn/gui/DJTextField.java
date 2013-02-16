package com.jg.hgsvn.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 */
public class DJTextField extends JTextField{
    public DJTextField() {
        this.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                // is Cmd/META down
                if (e.getModifiers() == Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()) {
                    if (e.getKeyCode() == KeyEvent.VK_X) {
                        ((JTextField) e.getSource()).cut();
                    }
                    else if (e.getKeyCode() == KeyEvent.VK_C) {
                        ((JTextField) e.getSource()).copy();
                    }
                    else if (e.getKeyCode() == KeyEvent.VK_V) {
                        ((JTextField) e.getSource()).paste();
                    }
                }
            }
        });
    }
}
