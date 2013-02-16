package com.jg.hgsvn.gui;

import com.jg.hgsvn.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 */
public class SettingsPanel extends JPanel {

    private JButton jButtonFindSvn;
    private JButton jButtonFindHg;
    private JButton jButtonFindGit;

    private JTextField svnTextField;
    private JTextField hgTextField;
    private JTextField gitTextField;

    public SettingsPanel() {
        super();
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        c.insets = new Insets(4, 4, 4, 4);
        add(new JLabel("Hg"), c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.insets = new Insets(4, 4, 4, 4);
        add(getHgTextField(), c);

        c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.gridx = 2;
        c.weightx = 1;
        add(getJButtonFindHg(), c);

        c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.gridy = 1;
        add(new JLabel("Svn"), c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(4, 4, 4, 4);
        add(getSvnTextField(), c);

        c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.gridy = 1;
        c.gridx = 2;
        c.weightx = 1;
        add(getJButtonFindSvn(), c);


        c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.gridy = 2;
        add(new JLabel("Git"), c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(4, 4, 4, 4);
        add(getGitTextField(), c);

        c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.gridy = 2;
        c.gridx = 2;
        c.weightx = 1;
        add(getJButtonFindGit(), c);

    }

    public JTextField getSvnTextField() {
        if (svnTextField == null) {
            svnTextField = new DJTextField();

            svnTextField.setText(Main.persistence.getSvnPath());
            Dimension dimension = new Dimension(200, 30);
            svnTextField.setPreferredSize(dimension);
            svnTextField.setMaximumSize(dimension);
            svnTextField.setMinimumSize(dimension);
            svnTextField.addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent keyEvent) {
                }

                public void keyPressed(KeyEvent keyEvent) {
                }

                public void keyReleased(KeyEvent keyEvent) {
                    Main.persistence.setSvnPath(svnTextField.getText());//To change body of implemented methods use File | Settings | File Templates.
                }
            });

        }
        return svnTextField;
    }

    public JTextField getGitTextField() {
        if (gitTextField == null) {
            gitTextField = new DJTextField();

            gitTextField.setText(Main.persistence.getGitPath());
            Dimension dimension = new Dimension(200, 30);
            gitTextField.setPreferredSize(dimension);
            gitTextField.setMaximumSize(dimension);
            gitTextField.setMinimumSize(dimension);
            gitTextField.addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent keyEvent) {
                }

                public void keyPressed(KeyEvent keyEvent) {
                }

                public void keyReleased(KeyEvent keyEvent) {
                    Main.persistence.setGitPath(gitTextField.getText());//To change body of implemented methods use File | Settings | File Templates.
                }
            });

        }
        return gitTextField;
    }


    public JTextField getHgTextField() {
        if (hgTextField == null) {
            hgTextField = new DJTextField();
            hgTextField.setText(Main.persistence.getHgPath());
            Dimension dimension = new Dimension(200, 30);
            hgTextField.setPreferredSize(dimension);
            hgTextField.setMaximumSize(dimension);
            hgTextField.setMinimumSize(dimension);
            hgTextField.addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent keyEvent) {
                }

                public void keyPressed(KeyEvent keyEvent) {
                }

                public void keyReleased(KeyEvent keyEvent) {
                    Main.persistence.setHgPath(hgTextField.getText());//To change body of implemented methods use File | Settings | File Templates.
                }
            });

        }
        return hgTextField;
    }

    public JButton getJButtonFindSvn() {
        if (jButtonFindSvn == null) {
            jButtonFindSvn = new JButton("Find executable");
            jButtonFindSvn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            jButtonFindSvn.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent mouseEvent) {
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int returnVal = chooser.showOpenDialog(MainFrame.instance);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        String absolutePath = chooser.getSelectedFile().getAbsolutePath();
                        getSvnTextField().setText(absolutePath);
                        Main.persistence.setSvnPath(absolutePath);
                    }
                }

                public void mousePressed(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void mouseReleased(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void mouseEntered(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void mouseExited(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }
            });


        }
        return jButtonFindSvn;
    }

    public JButton getJButtonFindHg() {
        if (jButtonFindHg == null) {
            jButtonFindHg = new JButton("Find executable");
            jButtonFindHg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            jButtonFindHg.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent mouseEvent) {
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int returnVal = chooser.showOpenDialog(MainFrame.instance);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        String absolutePath = chooser.getSelectedFile().getAbsolutePath();
                        getHgTextField().setText(absolutePath);
                        Main.persistence.setHgPath(absolutePath);
                    }
                }

                public void mousePressed(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void mouseReleased(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void mouseEntered(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void mouseExited(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }
            });


        }
        return jButtonFindHg;
    }


    public JButton getJButtonFindGit() {
        if (jButtonFindGit == null) {
            jButtonFindGit = new JButton("Find executable");
            jButtonFindGit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            jButtonFindGit.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent mouseEvent) {
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int returnVal = chooser.showOpenDialog(MainFrame.instance);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        String absolutePath = chooser.getSelectedFile().getAbsolutePath();
                        getGitTextField().setText(absolutePath);
                        Main.persistence.setGitPath(absolutePath);
                    }
                }

                public void mousePressed(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void mouseReleased(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void mouseEntered(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void mouseExited(MouseEvent mouseEvent) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }
            });


        }
        return jButtonFindGit;
    }

}
