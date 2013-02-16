package com.jg.hgsvn.model;

import java.util.*;

/**
 *
 */
public class Persistence {
    private List<String> workspaces = new ArrayList<String>();
    private List<Template> templates = new ArrayList<Template>();

    private String hgPath = "";
    private String gitPath = "";
    private String svnPath ="";

    private String selectedWorkspace;
    private String selectedTemplate;

    public List<String> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<String> workspaces) {
        this.workspaces = workspaces;
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    public String getHgPath() {
        return hgPath;
    }

    public void setHgPath(String hgPath) {
        this.hgPath = hgPath;
    }

    public String getSvnPath() {
        return svnPath;
    }

    public void setSvnPath(String svnPath) {
        this.svnPath = svnPath;
    }

    public String getGitPath() {
        return gitPath;
    }

    public void setGitPath(String gitPath) {
        this.gitPath = gitPath;
    }

    public String getSelectedWorkspace() {
        return selectedWorkspace;
    }

    public void setSelectedWorkspace(String selectedWorkspace) {
        this.selectedWorkspace = selectedWorkspace;
    }

    public String getSelectedTemplate() {
        return selectedTemplate;
    }

    public void setSelectedTemplate(String selectedTemplate) {
        this.selectedTemplate = selectedTemplate;
    }
    
    public Template getTemplate(String name){
        for (Template t : templates) {
            if(t.getName().equalsIgnoreCase(name)){
                return t;
            }
        }
        return null;
    }
}
