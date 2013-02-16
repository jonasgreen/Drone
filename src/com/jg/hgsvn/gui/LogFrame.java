package com.jg.hgsvn.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 */
public class LogFrame extends JFrame {

    private JTextArea textArea;
    private JScrollPane scrollPanel;

    public LogFrame() throws HeadlessException {
        super("Repository Drone - output");
        init();
    }

    private void init() {
        addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent windowEvent) {
                //TODO
            }

            public void windowClosing(WindowEvent windowEvent) {
                 setVisible(false);
            }

            public void windowClosed(WindowEvent windowEvent) {

            }

            public void windowIconified(WindowEvent windowEvent) {
                //TODO
            }

            public void windowDeiconified(WindowEvent windowEvent) {
                //TODO
            }

            public void windowActivated(WindowEvent windowEvent) {
                //TODO
            }

            public void windowDeactivated(WindowEvent windowEvent) {
                //TODO
            }
        });
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty =1;
        add(getScrollPanel(), c);
    }

    public JScrollPane getScrollPanel() {
        if (scrollPanel == null) {
            scrollPanel = new JScrollPane(getTextArea());
        }
        return scrollPanel;
    }

    public JTextArea getTextArea() {
        if (textArea == null) {
            textArea = new DJTextArea();
            Font f = new Font(Font.MONOSPACED, Font.PLAIN, 12);

            textArea.setFont(f);
            
            Dimension d =Toolkit.getDefaultToolkit().getScreenSize();
            d = new Dimension(550, (int)d.getHeight()-100);
            //textArea.setPreferredSize(d);
            //textArea.setMaximumSize(d);
            //textArea.setMinimumSize(d);
        }
        return textArea;
    }

    public void append(String line) {
        getTextArea().append(line);
        getScrollPanel().getVerticalScrollBar().setValue(getScrollPanel().getVerticalScrollBar().getMaximum());
    }
}
