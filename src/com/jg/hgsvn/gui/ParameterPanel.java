package com.jg.hgsvn.gui;

import com.jg.hgsvn.*;
import com.jg.hgsvn.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 */
public class ParameterPanel extends JPanel {



    private JPanel content;
    private ParameterMap shownParams = new ParameterMap();


    public ParameterPanel() {
        super();
        setLayout(new GridBagLayout());
    }


    public void add(ParameterMap newMap) {
        for (Parameter p : shownParams.getParamList()) {
            if (newMap.contains(p)) {
                newMap.put(p);
            }
        }
        this.shownParams = newMap;
        repaintContent();
    }

    private void repaintContent() {
        if (content != null) {
            remove(content);
        }
        content = new JPanel();

        content.setLayout(new GridBagLayout());
        content.setBackground(Colors.TEMPLATE);
        int gridY = 0;
        GridBagConstraints c;
        for (Parameter p : shownParams.getParamList()) {
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = gridY;
            c.anchor = GridBagConstraints.WEST;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0, 0, 0, 8);
            content.add(new JLabel(p.getName()), c);

            c = new GridBagConstraints();
            c.gridx = 1;
            c.gridy = gridY++;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1;
            final Parameter pFinal = p;
            final JTextField jTextField = new DJTextField();
            jTextField.setText(p.getValue());
            jTextField.addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent keyEvent) {
                    //TODO
                }

                public void keyPressed(KeyEvent keyEvent) {
                    //TODO
                }

                public void keyReleased(KeyEvent keyEvent) {
                    pFinal.setValue(jTextField.getText());
                }
            });
            content.add(jTextField, c);
        }

        GridBagConstraints nc = new GridBagConstraints();
        nc.gridx = 0;
        nc.gridy = 0;
        nc.weightx = 1;
        nc.fill = GridBagConstraints.HORIZONTAL;

        add(content, nc);

        content.updateUI();
        content.repaint();
        this.repaint();
    }

    
    public ParameterMap getParameters(){
        return shownParams;
    }
    
}
