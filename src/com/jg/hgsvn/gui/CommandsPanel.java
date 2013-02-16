package com.jg.hgsvn.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 */
public class CommandsPanel extends JPanel {
    private TemplatePanel parent;

    private JTextArea hgTextArea;
    private JTextArea svnTextArea;
    private JTextArea gitTextArea;

    public CommandsPanel(TemplatePanel parent) {
        super();
        this.parent = parent;
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());
        setBackground(Colors.TEMPLATE);
        GridBagConstraints c;

        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        JScrollPane scrollPane = new JScrollPane(getGitTextArea());
        scrollPane.setBackground(Color.white);
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Git commands");
        scrollPane.setBorder(title);
        scrollPane.setMinimumSize(Sizes.COMMANDS_PANEL);
        scrollPane.setPreferredSize(Sizes.COMMANDS_PANEL);
        scrollPane.setMaximumSize(Sizes.COMMANDS_PANEL);
        add(scrollPane, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.EAST;
        scrollPane = new JScrollPane(getHgTextArea());
        scrollPane.setMinimumSize(Sizes.COMMANDS_PANEL);
        scrollPane.setPreferredSize(Sizes.COMMANDS_PANEL);
        scrollPane.setMaximumSize(Sizes.COMMANDS_PANEL);
        title = BorderFactory.createTitledBorder("Hg commands");
        scrollPane.setBorder(title);
        add(scrollPane, c);


        c = new GridBagConstraints();
        c.gridx = 2;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.EAST;
        scrollPane = new JScrollPane(getSvnTextArea());
        scrollPane.setMinimumSize(Sizes.COMMANDS_PANEL);
        scrollPane.setPreferredSize(Sizes.COMMANDS_PANEL);
        scrollPane.setMaximumSize(Sizes.COMMANDS_PANEL);
        title = BorderFactory.createTitledBorder("Svn commands");
        scrollPane.setBorder(title);
        add(scrollPane, c);


    }



    public JTextArea getHgTextArea() {
        if (hgTextArea == null) {
            hgTextArea = createTextArea();

        }
        return hgTextArea;
    }

    public JTextArea getGitTextArea() {
        if (gitTextArea == null) {
            gitTextArea = createTextArea();
        }
        return gitTextArea;
    }

    private JTextArea createTextArea() {
        JTextArea textArea = new DJTextArea();
        textArea.setBackground(Color.white);
        Font f = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        textArea.setFont(f);
        textArea.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent keyEvent) {
            }

            public void keyPressed(KeyEvent keyEvent) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void keyReleased(KeyEvent keyEvent) {
                parent.commandsChanged();

            }
        });
        return textArea;
    }

    public JTextArea getSvnTextArea() {
        if (svnTextArea == null) {
            svnTextArea = createTextArea();
        }
        return svnTextArea;
        
    }

}
