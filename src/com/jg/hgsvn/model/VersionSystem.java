package com.jg.hgsvn.model;

import com.jg.hgsvn.gui.*;

import java.io.*;
import java.util.*;

/**
 *
 */
public abstract class VersionSystem {

    public static String svn = "svn";
    public static String HG = "hg";
    public static String GIT = "git";

    private String name;
    private List<File> selectedDirs = new ArrayList<File>();
    private List<CommandLine> commandLines = new ArrayList<CommandLine>();

    protected VersionSystem(String name) {
        this.name = name;
    }

    public static VersionSystem create(String versionSystemString) throws ValidationException {
        String vcs = versionSystemString.trim().toLowerCase();
        if (svn.equals(vcs)) {
            return new Svn();
        }
        if (HG.equals(vcs)) {
            return new Hg();
        }
        if (GIT.equals(vcs)) {
            return new Git();
        }

        throw new ValidationException("Invalid version system.", "Valid version systems are -svn, -hg, -git.");
    }

    public static List<VersionSystem> createAll() {
        List<VersionSystem> all = new ArrayList<VersionSystem>();
        all.add(new Svn());
        all.add(new Hg());
        all.add(new Git());

        return all;
    }

    public String getDirIdName(){
        return "."+getName();
    }

    public String getName() {
        return name;
    }

    public List<File> getSelectedDirs() {
        return selectedDirs;
    }

    public void setSelectedDirs(List<File> selectedDirs) {
        this.selectedDirs = selectedDirs;
    }

    public List<CommandLine> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(List<CommandLine> commandLines) {
        this.commandLines = commandLines;
    }

    public abstract String getTemplateCommandString(Template t);
    public abstract String getExecutionPath();

    public void validateExcecutionPath() throws ValidationException{
        String path = getExecutionPath();
        if (path == null || !(new File(path).isFile())) {
            throw new ValidationException(getName()+ " settings fail", "Please go to settings and set the path to your "+getName() +" executable.");
        }
    }

}
