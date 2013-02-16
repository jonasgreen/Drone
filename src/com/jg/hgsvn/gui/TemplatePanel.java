package com.jg.hgsvn.gui;

import com.jg.hgsvn.*;
import com.jg.hgsvn.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 */
public class TemplatePanel extends JPanel{

    private MainRightPanel parent;
    private JTextField templateNameField;
    private CommandsPanel commandsPanel;
    private ParameterPanel parameterPanel;
    private JPanel filler;

    public TemplatePanel(MainRightPanel parent) {
        this.parent = parent;
        init();
    }

    private void init() {
        int yCount = 0;
        setBackground(Colors.TEMPLATE);
        setLayout(new GridBagLayout());
        GridBagConstraints c;

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1;
        c.gridy = yCount++;
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.insets = new Insets(8,Sizes.LEFT_TAB,8,8);
        add(createTemplatePanel(), c);

        c = new GridBagConstraints();
        c.gridy =yCount++;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(4,4,0,4);
        c.anchor = GridBagConstraints.WEST;
        add(getCommandsPanel(), c);

        c = new GridBagConstraints();
        c.weightx = 1;
        c.gridy = yCount++;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(8,Sizes.LEFT_TAB,8,Sizes.LEFT_TAB);
        add(getParameterPanel(), c);


        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = yCount++;
        c.weightx = 1;
        c.weighty = 1;

        add(getFiller(), c);

        
    }


    public ParameterPanel getParameterPanel() {
        if (parameterPanel == null) {
            parameterPanel = new ParameterPanel();
        }
        return parameterPanel;
    }

    private JPanel createTemplatePanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Colors.TEMPLATE);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0,Sizes.LEFT_TAB,0,12);
        c.fill =GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Template name"), c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        panel.add(getTemplateNameField(), c);


     
        return panel;
    }

    public CommandsPanel getCommandsPanel() {
        if (commandsPanel == null) {
            commandsPanel = new CommandsPanel(this);
        }
        return commandsPanel;
    }

    public JTextField getTemplateNameField() {
        if (templateNameField == null) {
            templateNameField = new DJTextField();
            templateNameField.setPreferredSize(Sizes.TEMPLATE_NAME);
            templateNameField.setMaximumSize(Sizes.TEMPLATE_NAME);
            templateNameField.setMinimumSize(Sizes.TEMPLATE_NAME);
            templateNameField.addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent keyEvent) {

                }

                public void keyPressed(KeyEvent keyEvent) {
                    //TODO
                }

                public void keyReleased(KeyEvent keyEvent) {
                    MainFrame.instance.templateNameChanged(getTemplateNameField().getText());
                }
            });
        }
        return templateNameField;
    }

    public void updateParameterList(){
        String hgText = getCommandsPanel().getHgTextArea().getText();
        String svnText = getCommandsPanel().getSvnTextArea().getText();
        String gitText = getCommandsPanel().getGitTextArea().getText();
        getParameterPanel().add(new ParameterMap(gitText, hgText, svnText));
    }

    public void setTemplate(Template t) {
        if(t == null){
            getTemplateNameField().setText("");
            getCommandsPanel().getGitTextArea().setText("");
            getCommandsPanel().getHgTextArea().setText("");
            getCommandsPanel().getSvnTextArea().setText("");
            updateParameterList();
            return;
        }
        getTemplateNameField().setText(t.getName());
        getCommandsPanel().getGitTextArea().setText(t.getGitCommandString());
        getCommandsPanel().getHgTextArea().setText(t.getHgCommandString());
        getCommandsPanel().getSvnTextArea().setText(t.getSvnCommandString());

        updateParameterList();
    }


    public JPanel getFiller() {
        if (filler == null) {
            filler = new JPanel();
            filler.setBackground(Colors.TEMPLATE);
        }
        return filler;
    }

    public void commandsChanged() {
        Template t = MainFrame.left.getTemplateSelectorPanel().getSelectedTemplate();
        if(t != null){
            t.setHgCommandString(getCommandsPanel().getHgTextArea().getText());
            t.setSvnCommandString(getCommandsPanel().getSvnTextArea().getText());
            t.setGitCommandString(getCommandsPanel().getGitTextArea().getText());
        }
        updateParameterList();
    }
}
