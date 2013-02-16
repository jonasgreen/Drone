package com.jg.hgsvn.gui;

import com.jg.hgsvn.*;
import com.jg.hgsvn.model.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 *
 */
public class TemplateSelectorPanel extends JPanel {


    private JList list;
    DefaultListModel model = new DefaultListModel();

    private List<Template> templates;

    public TemplateSelectorPanel(List<Template> templates) {
        super();
        this.templates = templates == null ? new ArrayList<Template>() : templates;
        init();
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

    private void setLastSelectedItem(String selectedTemplate) {
        if (selectedTemplate != null && !selectedTemplate.equals("")) {
            int i = 0;
            int size = model.getSize();
            while (i < size) {
                Template t = (Template) model.get(i);
                if (t.getName().equals(selectedTemplate)) {
                    getList().setSelectedIndex(i);
                    break;
                }
                i++;
            }
        }
    }

    public void loadTemplates(List<Template> templates, String selectedTemplate) {
        model = new DefaultListModel();
        for (Template t : templates) {
            model.addElement(t);
        }
        getList().setModel(model);

        setLastSelectedItem(selectedTemplate);

        getList().repaint();
    }

    public JList getList() {
        if (list == null) {
            for (Template t : templates) {
                model.addElement(t);
            }
            list = new JList(model);
            list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            list.setBackground(Colors.SELECTION_LIST_BACKGROUND);
            //list.setCellRenderer(new SelectedCellRenderer(Colors.TEMPLATE));
            list.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent listSelectionEvent) {
                    selectionChanged();
                }
            });
        }
        return list;
    }

    private void selectionChanged() {
        Template t = getSelectedTemplate();
        MainFrame.right.getTemplatePanel().setTemplate(t);
        Main.persistence.setSelectedTemplate(t == null ? "" : t.getName());
    }

    public void deleteSelected() {
        int index = getList().getSelectedIndex();
        if (index != -1) {
            model.remove(index);
        }
    }

    public void addNewTemplate() {
        Template t = new Template("", "", "", "New template");
        model.addElement(t);
        list.setSelectedIndex(model.getSize() - 1);
    }

    public void templateNameChanged(String text) {
        Template t = getSelectedTemplate();
        if (t != null) {
            t.setName(text);
            getList().repaint();
        }
    }

    public Template getSelectedTemplate() {
        int selectedIndex = getList().getSelectedIndex();
        if (selectedIndex == -1) {
            return null;
        }
        return (Template) model.get(selectedIndex);
    }

    public void commmandsChanged(String hgText, String svnText) {
        Template t = getSelectedTemplate();
        if (t != null) {
            t.setHgCommandString(hgText);
            t.setSvnCommandString(svnText);
        }
    }

    public List<Template> getTemplates() {
        List<Template> list = new ArrayList<Template>();
        int i = 0;
        while (i < model.getSize()) {
            list.add((Template) model.get(i++));
        }
        return list;
    }


}
