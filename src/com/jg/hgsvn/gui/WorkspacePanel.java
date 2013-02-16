package com.jg.hgsvn.gui;

import com.jg.hgsvn.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 *
 */
public class WorkspacePanel extends JPanel{

    private MainRightPanel parent;
    private JLabel workspaceDir;
    private RepDirPanel dirs;

    public WorkspacePanel(MainRightPanel parent) {
        this.parent = parent;
        init();
    }

    private void init() {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints c;

        JPanel panel =new JPanel(new GridBagLayout());
        panel.setBackground(Colors.WORKSPACE);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 1;
        c.insets = new Insets(7,Sizes.LEFT_TAB,0,8);
        panel.add(getWorkspaceDir(), c);

        
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHEAST;
        c.gridx = 1;        
        c.insets = new Insets(0,0,0,8);
        panel.add(getSettingsButton(), c); 
        
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        add(panel, c);
        
        c = new GridBagConstraints();
        c.gridy =1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0,4,8,4);
        add(getDirs(), c);
    }


    public JLabel getWorkspaceDir() {
        if (workspaceDir == null) {
            workspaceDir = new JLabel("Select or add a workspace");
            workspaceDir.setBackground(Colors.WORKSPACE);
        }
        return workspaceDir;
    }

    public RepDirPanel getDirs() {
        if (dirs == null) {
            dirs = new RepDirPanel();
        }
        return dirs;
    }

    public void setWorkspace(String workspace) {
        java.util.List<File> gitSubDirs = new ArrayList<File>();
        java.util.List<File> hgSubDirs = new ArrayList<File>();
        java.util.List<File> svnSubDirs = new ArrayList<File>();

        String label = "Workspace: "+workspace;
        if(workspace == null || workspace.equals("")){
           label = "Select or add a workspace";
        }
        else if(validateWorkspace(workspace)){
            hgSubDirs = FileUtil.getHgSubDirs(new File(workspace));
            svnSubDirs = FileUtil.getSvnSubDirs(new File(workspace));
            gitSubDirs = FileUtil.getGitSubDirs(new File(workspace));
        }
        else{
            label = "ERROR - workspace is not a directory";
        }
        getWorkspaceDir().setText(label);
        getDirs().getGitFileFrame().addFilesList(gitSubDirs);
        getDirs().getHgFileFrame().addFilesList(hgSubDirs);
        getDirs().getSvnFileFrame().addFilesList(svnSubDirs);
    }


    private boolean validateWorkspace(String workspace) {
        File dir = new File(workspace);
        return dir.isDirectory();
    }

    private JButton getSettingsButton() {
        Icon i = new ImageIcon(MainRightPanel.class.getResource("/Settings-32.png"));
        JButton settings = new JButton(i);
        settings.setToolTipText("Settings");
        settings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Dimension d = new Dimension(32, 32);
        settings.setPreferredSize(d);
        settings.setMaximumSize(d);
        settings.setMinimumSize(d);
        settings.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent mouseEvent) {
                openSettings();
            }

            public void mousePressed(MouseEvent mouseEvent) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void mouseReleased(MouseEvent mouseEvent) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void mouseEntered(MouseEvent mouseEvent) {

            }

            public void mouseExited(MouseEvent mouseEvent) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        return settings;
    }

    private void openSettings() {
        JOptionPane.showConfirmDialog(MainFrame.instance, new SettingsPanel(), "Please specify path to executables", JOptionPane.PLAIN_MESSAGE);

    }

}
