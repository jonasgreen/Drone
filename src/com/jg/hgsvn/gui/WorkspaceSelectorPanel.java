package com.jg.hgsvn.gui;

import com.jg.hgsvn.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 *
 */
public class WorkspaceSelectorPanel extends JPanel {


    private JList list;
    DefaultListModel model = new DefaultListModel();


    private List<String> workspaces;

    public WorkspaceSelectorPanel(List<String> workspaces) {
        super();
        this.workspaces = workspaces == null ? new ArrayList<String>() : workspaces;
        init();
    }

    public void loadWorkspaces(List<String> workspaces, String selectedWorkspace) {
        model = new DefaultListModel();
        for (String w : workspaces) {
            model.addElement(w);
        }
        getList().setModel(model);
        
        setLastSelectedItem(selectedWorkspace);
        getList().repaint();

    }

    private void init() {
        setLayout(new GridBagLayout());
        setBackground(Colors.SELECTION_LIST_BACKGROUND);
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;

        add(getList(), c);
    }

    private void setLastSelectedItem(String workspace) {
        workspace = Main.persistence.getSelectedWorkspace();
        if (workspace != null && !workspace.equals("")) {
            int i = 0;
            int size = model.getSize();
            while (i < size) {
                String w = (String) model.get(i);
                if (w.equals(workspace)) {
                    getList().setSelectedIndex(i);
                    break;
                }
                i++;
            }
        }
    }


    public JList getList() {
        if (list == null) {
            for (String workspace : workspaces) {
                model.addElement(workspace);
            }
            list = new JList(model);
            //list.setCellRenderer(new SelectedCellRenderer(Color.WHITE));
            list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            list.setBackground(Colors.SELECTION_LIST_BACKGROUND);
            list.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent listSelectionEvent) {
                    selectionChanged();
                }
            });
        }
        return list;
    }

    private void selectionChanged() {
        String selectedValue = (String) getList().getSelectedValue();
        MainFrame.right.getWorkSpacePanel().setWorkspace(selectedValue);
        Main.persistence.setSelectedWorkspace(selectedValue);
    }

    public void deleteSelected() {
        int index = getList().getSelectedIndex();
        if (index != -1) {
            model.remove(index);
        }
    }
    
    public String getSelected(){
        int index = getList().getSelectedIndex();
        if (index == -1) {
            return null;
        }
        return (String)model.get(index);
    }

    public void addNewWorkspace() {

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String workspace = chooser.getSelectedFile().getAbsolutePath();
            model.addElement(workspace);
            list.setSelectedIndex(model.getSize() - 1);
            list.repaint();
        }
    }

    public List<String> getWorkspaces() {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (i < model.getSize()) {
            list.add((String) model.get(i++));
        }
        return list;
    }
}
