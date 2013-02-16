package com.jg.hgsvn.gui;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class MainLeftPanel extends JPanel{


    private WorkspaceSelectorPanel workspacePanel;
    private TemplateSelectorPanel templateSelectorPanel;

    public MainLeftPanel() {
        super();
        init();
    }

    private void init() {
        setBackground(Colors.SELECTION_LIST_BACKGROUND);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(new WorkspacesMenuBar(this), c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        
        add(getWorkspacePanel(), c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 0;
        c.weighty =0;
        c.fill = GridBagConstraints.HORIZONTAL;

        add(new TemplateMenuBar(this), c);


        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        add(getTemplateSelectorPanel(), c);



    }

    public WorkspaceSelectorPanel getWorkspacePanel() {
        if (workspacePanel == null) {
            workspacePanel = new WorkspaceSelectorPanel(null);
        }
        return workspacePanel;
    }

    public TemplateSelectorPanel getTemplateSelectorPanel() {
        if (templateSelectorPanel == null) {
            templateSelectorPanel = new TemplateSelectorPanel(null);
        }
        return templateSelectorPanel;
    }


    public void deleteSelectedWorkspace() {
        getWorkspacePanel().deleteSelected();
    }

    public void addWorkspace() {
        getWorkspacePanel().addNewWorkspace();
    }

    public void addNewTemplate() {
        getTemplateSelectorPanel().addNewTemplate();
    }

    public void deleteSelected() {
        getTemplateSelectorPanel().deleteSelected();
    }

    public void templateNameChanged(String text) {
        getTemplateSelectorPanel().templateNameChanged(text);
    }

    public void comandsChanged(String hgText, String svnText) {
        getTemplateSelectorPanel().commmandsChanged(hgText, svnText);
    }
}
