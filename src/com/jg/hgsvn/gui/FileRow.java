package com.jg.hgsvn.gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *
 */
public class FileRow extends JPanel{
    private JCheckBox checkBox;
    private File file;


    public FileRow(File file) {
        this.file = file;
        init();
    }

    private void init() {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.NONE;
        add(getCheckBox(), c);



    }


    public File getFile() {
        return file;
    }

    public JCheckBox getCheckBox() {
        if (checkBox == null) {
            checkBox = new JCheckBox(file.getName());
            checkBox.setSelected(true);
            checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        }
        return checkBox;
    }


}
