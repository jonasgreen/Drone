package com.jg.hgsvn.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 */
public class DJTextArea extends JTextArea{
    public DJTextArea() {
        this.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                // is Cmd/META down
                if (e.getModifiers() == Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()) {
                    if (e.getKeyCode() == KeyEvent.VK_X) {
                        ((JTextArea) e.getSource()).cut();
                    }
                    else if (e.getKeyCode() == KeyEvent.VK_C) {
                        ((JTextArea) e.getSource()).copy();
                    }
                    else if (e.getKeyCode() == KeyEvent.VK_V) {
                        ((JTextArea) e.getSource()).paste();
                    }
                }
            }
        });
    }
}
