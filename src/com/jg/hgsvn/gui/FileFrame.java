package com.jg.hgsvn.gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

/**
 *
 */
public class FileFrame extends JPanel{
    private List<FileRow> rows = new ArrayList<FileRow>();
    JPanel content;
    
    
    public FileFrame() throws HeadlessException {
        init();
    }

    private void init() {
        
        setLayout(new GridBagLayout());
        setBackground(Color.white);
    }
    
    public void addFilesList(List<File> files){
        if(content != null){
            remove(content);
            rows = new ArrayList<FileRow>();
        }
        content = new JPanel();
        content.setLayout(new GridBagLayout());
        content.setBackground(Color.WHITE);
        GridBagConstraints c;

        setBackground(Color.white);
        int y = 0;
        int count = 0;
        for (File f : files) {
            c = new GridBagConstraints();
            c.gridy = y++;
            c.gridx =0;
            c.weightx = 1;
            c.anchor = GridBagConstraints.WEST;
            c.fill = GridBagConstraints.HORIZONTAL;
            if(count == files.size()-1){
                c.weighty = 1;
                c.anchor = GridBagConstraints.NORTHWEST;
            }

            count++;
            FileRow fr = new FileRow(f);
            content.add(fr, c);
            
            rows.add(fr);
            
        }

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weighty = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.VERTICAL;
        add(content, c);
        updateUI();

    }

    public List<File> getSelectedDirs() {
        List<File> list = new ArrayList<File>();
        for (FileRow row : rows) {
            if(row.getCheckBox().isSelected()){
                list.add(row.getFile());
            }
        }
        return list;
    }
}
