package com.jg.hgsvn.gui;

import com.jg.hgsvn.*;
import com.jg.hgsvn.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 *
 */
public class MainFrameButtons extends JPanel {

    private Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 36);

    private JButton run;

    public MainFrameButtons() {
        super();
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());

        setBackground(Color.WHITE);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);
        c.weightx = 1;
        c.anchor = GridBagConstraints.EAST;
        add(getRun(), c);
    }


    public JButton getRun() {
        if (run == null) {
            run = new JButton("Run");
            run.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            run.setFont(font);
            run.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent mouseEvent) {
                    run();
                }

                public void mousePressed(MouseEvent mouseEvent) {
                    //TODO
                }

                public void mouseReleased(MouseEvent mouseEvent) {
                    //TODO
                }

                public void mouseEntered(MouseEvent mouseEvent) {
                    //TODO
                }

                public void mouseExited(MouseEvent mouseEvent) {
                    //TODO
                }
            });
        }
        return run;
    }

    private void run() {
        try {
            Template t = MainFrame.left.getTemplateSelectorPanel().getSelectedTemplate();
            String workspace = MainFrame.left.getWorkspacePanel().getSelected();

            List<File> gitFiles = MainFrame.right.getWorkSpacePanel().getDirs().getGitFileFrame().getSelectedDirs();
            List<File> hgFiles = MainFrame.right.getWorkSpacePanel().getDirs().getHgFileFrame().getSelectedDirs();
            List<File> svnFiles = MainFrame.right.getWorkSpacePanel().getDirs().getSvnFileFrame().getSelectedDirs();

            List<VersionSystem> vsList = new ArrayList<VersionSystem>();
            if(!isEmpty(gitFiles)){
                vsList.add(new Git(gitFiles));
            }
            if(!isEmpty(hgFiles)){
                vsList.add(new Hg(hgFiles));
            }
            if(!isEmpty(svnFiles)){
                vsList.add(new Svn(svnFiles));
            }

            ToRun data = new ToRun(vsList, t, workspace, MainFrame.right.getTemplatePanel().getParameterPanel().getParameters());

            Execution e = new Execution(data);
            e.execute();

        }
        catch (ValidationException e) {
            JOptionPane.showConfirmDialog(MainFrame.instance, e.getMessage(), e.getTitle(), JOptionPane.PLAIN_MESSAGE);
        }
    }

    private boolean isEmpty(List<File> list){
        return list == null || list.isEmpty();
    }



}
