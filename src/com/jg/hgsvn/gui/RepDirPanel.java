package com.jg.hgsvn.gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 *
 */
public class RepDirPanel extends JPanel {
    private FileFrame hgFileFrame;
    private FileFrame svnFileFrame;
    private FileFrame gitFileFrame;

    public RepDirPanel() {
        super();
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());
        setBackground(Colors.WORKSPACE);
        GridBagConstraints c;

        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        JScrollPane scrollPane = new JScrollPane(getGitFileFrame());
        scrollPane.setBackground(Color.white);
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Git dirs");
        scrollPane.setBorder(title);
        scrollPane.setMinimumSize(Sizes.REP_DIR_PANEL);
        scrollPane.setPreferredSize(Sizes.REP_DIR_PANEL);
        scrollPane.setMaximumSize(Sizes.REP_DIR_PANEL);

        add(scrollPane, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.EAST;

        scrollPane = new JScrollPane(getHgFileFrame());
        scrollPane.setMinimumSize(Sizes.REP_DIR_PANEL);
        scrollPane.setPreferredSize(Sizes.REP_DIR_PANEL);
        scrollPane.setMaximumSize(Sizes.REP_DIR_PANEL);
        title = BorderFactory.createTitledBorder("Hg dirs");
        scrollPane.setBorder(title);
        add(scrollPane, c);



        c = new GridBagConstraints();
        c.gridx = 2;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.EAST;

        scrollPane = new JScrollPane(getSvnFileFrame());
        scrollPane.setMinimumSize(Sizes.REP_DIR_PANEL);
        scrollPane.setPreferredSize(Sizes.REP_DIR_PANEL);
        scrollPane.setMaximumSize(Sizes.REP_DIR_PANEL);
        title = BorderFactory.createTitledBorder("Svn dirs");
        scrollPane.setBorder(title);
        add(scrollPane, c);


    }



    public FileFrame getHgFileFrame() {
        if (hgFileFrame == null) {
            hgFileFrame = new FileFrame();

        }
        return hgFileFrame;
    }

    public FileFrame getGitFileFrame() {
        if (gitFileFrame == null) {
            gitFileFrame = new FileFrame();
        }
        return gitFileFrame;
    }

    public FileFrame getSvnFileFrame() {
        if (svnFileFrame == null) {
            svnFileFrame = new FileFrame();
        }
        return svnFileFrame;
        
    }

}
