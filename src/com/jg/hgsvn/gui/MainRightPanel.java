package com.jg.hgsvn.gui;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class MainRightPanel extends JPanel{
    private WorkspacePanel workSpacePanel;
    private TemplatePanel templatePanel;
    private MainFrameButtons buttons;

    public MainRightPanel() throws HeadlessException {
        super();
        init();
    }

    private void init() {
        int gridYCount = 0;
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints c;

        c = new GridBagConstraints();
        c.weightx = 1;
        c.gridy = gridYCount++;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(getWorkSpacePanel(), c);
        

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridy = gridYCount++;
        c.insets = new Insets(20,0,2,2);

        add(getTemplatePanel(), c);


        c = new GridBagConstraints();
        c.gridy = gridYCount++;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        add(getButtons(), c);

    }


    public WorkspacePanel getWorkSpacePanel() {
        if (workSpacePanel == null) {
            workSpacePanel = new WorkspacePanel(this);
            workSpacePanel.setBackground(Colors.WORKSPACE);
        }
        return workSpacePanel;
    }

    public TemplatePanel getTemplatePanel() {
        if (templatePanel == null) {
            templatePanel = new TemplatePanel(this);
            templatePanel.setBackground(Colors.TEMPLATE);
        }
        return templatePanel;
    }

    public MainFrameButtons getButtons() {
        if (buttons == null) {
            buttons = new MainFrameButtons();
            buttons.setBackground(Colors.TEMPLATE);


        }
        return buttons;
    }

    

    
   
   
}
