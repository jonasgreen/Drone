package com.jg.hgsvn;

import com.jg.hgsvn.gui.*;
import com.jg.hgsvn.model.*;
import com.thoughtworks.xstream.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Main {

    private static String INIT_FILE_NAME = "repos_drone_config.txt";

    public static Persistence persistence;
    public static MainFrame main;
    public static LogFrame logFrame;

    public static void main(String args[]) {

        try {

            persistence = loadPersistence();

            if(!containsArgument(args)){
                loadGui();
            }
            else{
                loadArguments(args);
            }

        }
        catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    private static boolean containsArgument(String[] args) {
        if(args == null || args.length == 0){
            return false;
        }
        for (String arg : args) {
            if(arg != null && !arg.equals("")){
                return true;
            }
        }
        return false;
    }

    private static void loadArguments(String[] args) {
        CommandLineStyle cls = new CommandLineStyle();
        cls.run(args);
    }

    private static void loadGui() {
        setLookAndFeel();

        main = new MainFrame();
        main.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        main.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent windowEvent) {
                //TODO
            }

            public void windowClosing(WindowEvent windowEvent) {
                exit();
            }

            public void windowClosed(WindowEvent windowEvent) {
                //TODO
            }

            public void windowIconified(WindowEvent windowEvent) {
                //TODO
            }

            public void windowDeiconified(WindowEvent windowEvent) {
                //TODO
            }

            public void windowActivated(WindowEvent windowEvent) {
                main.requestFocus();
            }

            public void windowDeactivated(WindowEvent windowEvent) {
                //TODO
            }
        });
        main.setSize(1500, 700);
        main.setLocationRelativeTo(null);
        main.setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }


    private static Persistence loadPersistence() throws IOException {
        File f = getInitFile();
        FileInputStream fstream = new FileInputStream(f);
        try {
            return (Persistence) new XStream().fromXML(new InputStreamReader(fstream, "UTF-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
            return new Persistence();
        }
    }


    private static void savePersistence(Persistence p) throws IOException {
        File f = getInitFile();
        f.delete();
        f = getInitFile();
        FileOutputStream out = new FileOutputStream(f);
        new XStream().toXML(p, new BufferedWriter(new OutputStreamWriter(out, "UTF-8")));
    }

    private static File getInitFile() throws IOException {
        String homeDir = System.getProperty("user.home");
        homeDir = ensureFileSep(homeDir);
        File f = new File(homeDir);
        if (f.exists()) {
            return f;
        }
        else {
            f.createNewFile();

        }
        return f;
    }

    private static String ensureFileSep(String homeDir) {
        if (homeDir.endsWith(File.separator)) {
            return homeDir + INIT_FILE_NAME;
        }
        return homeDir + File.separator + INIT_FILE_NAME;
    }

    public static void exit() {
        persistence.setTemplates(MainFrame.left.getTemplateSelectorPanel().getTemplates());
        persistence.setWorkspaces(MainFrame.left.getWorkspacePanel().getWorkspaces());
        try {
            savePersistence(persistence);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);

        }
        System.exit(0);
    }

    public static void printout(final String line) {
        if (main != null) {

            if (logFrame == null) {
                logFrame = new LogFrame();
                Dimension d =Toolkit.getDefaultToolkit().getScreenSize();
                logFrame.setSize(560, (int)d.getHeight());
            }
            logFrame.setVisible(true);
            logFrame.append(line);
            logFrame.append("\n");


        }
        else {
            System.out.println(line);
        }
    }
}
