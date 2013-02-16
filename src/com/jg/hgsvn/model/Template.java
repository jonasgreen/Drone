package com.jg.hgsvn.model;

/**
 *
 */
public class Template {
    private String svnCommandString;
    private String hgCommandString;
    private String gitCommandString;

    private String name;

    public Template(String svnCommandString, String hgCommandString, String gitCommandString, String name) {
        this.svnCommandString = svnCommandString;
        this.hgCommandString = hgCommandString;
        this.gitCommandString = gitCommandString;
        this.name = name;
    }

    public Template() {
    }

    public String getSvnCommandString() {
        return svnCommandString;
    }

    public void setSvnCommandString(String svnCommandString) {
        this.svnCommandString = svnCommandString;
    }

    public String getHgCommandString() {
        return hgCommandString;
    }

    public void setHgCommandString(String hgCommandString) {
        this.hgCommandString = hgCommandString;
    }

    public String getGitCommandString() {
        return gitCommandString;
    }

    public void setGitCommandString(String gitCommandString) {
        this.gitCommandString = gitCommandString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString(){
        return name;
    }
}
