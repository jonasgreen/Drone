package com.jg.hgsvn.model;

import com.jg.hgsvn.*;

import java.io.*;
import java.util.*;

/**
 *
 */
public class Svn extends VersionSystem{

    public Svn(List<File> list) {
        this();
        setSelectedDirs(list);
    }

    public Svn() {
        super(VersionSystem.svn);
    }

    @Override
    public String getTemplateCommandString(Template t) {
        return t.getSvnCommandString();
    }

    @Override
    public String getExecutionPath(){
        return Main.persistence.getSvnPath();
    }
}
