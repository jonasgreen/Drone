package com.jg.hgsvn.gui;

import com.jg.hgsvn.*;
import com.jg.hgsvn.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 *
 */
public class MainFrame extends JFrame {
    public static MainFrame instance;
    private static String name = "Repository Drone";
    public static MainRightPanel right = null;
    public static MainLeftPanel left = null;
   // public static JSplitPane split = null;


    public MainFrame() throws HeadlessException {

        instance = this;
        right = new MainRightPanel();
        left = new MainLeftPanel();

        setTitle(name);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 2;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        add(left, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.BOTH;
        add(right, c);

        //   split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, left, right);
     //   split.setBackground(Colors.menuBar);
     //   add(split, c);

        loadPersistence();
    }

    private void loadPersistence() {
        if (Main.persistence != null) {
            List<String> workspaces = Main.persistence.getWorkspaces();
            workspaces = workspaces == null ? new ArrayList<String>() : workspaces;
            left.getWorkspacePanel().loadWorkspaces(workspaces, Main.persistence.getSelectedWorkspace());

            List<Template> templates = Main.persistence.getTemplates();
            templates = templates == null ? new ArrayList<Template>() : templates;
            left.getTemplateSelectorPanel().loadTemplates(templates, Main.persistence.getSelectedTemplate());

        }
    }

    public void exit() {
        Main.exit();
    }

    public static void setNewTitle(String label) {
        instance.setTitle(name + " - " + label);
    }

    public void templateNameChanged(String text) {
        left.templateNameChanged(text);
    }

    public void commandsChanged(String hgText, String svnText) {
        left.comandsChanged(hgText, svnText);
    }


}
