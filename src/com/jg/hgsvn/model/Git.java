package com.jg.hgsvn.model;

import com.jg.hgsvn.*;

import java.io.*;
import java.util.*;

/**
 *
 */
public class Git extends VersionSystem{

    public Git(List<File> list) {
        this();
        setSelectedDirs(list);
    }

    public Git() {
        super(VersionSystem.GIT);
    }


    @Override
    public String getTemplateCommandString(Template t) {
        return t.getGitCommandString();
    }

    @Override
    public String getExecutionPath() {
        return Main.persistence.getGitPath();
    }

}
