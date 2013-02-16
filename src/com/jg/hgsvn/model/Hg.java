package com.jg.hgsvn.model;

import com.jg.hgsvn.*;

import java.io.*;
import java.util.*;

/**
 *
 */
public class Hg extends VersionSystem{


    public Hg(List<File> list) {
        this();
        setSelectedDirs(list);
    }

    protected Hg() {
        super(VersionSystem.HG);
    }

    @Override
    public String getTemplateCommandString(Template t) {
        return t.getHgCommandString();
    }

    @Override
    public String getExecutionPath(){
        return Main.persistence.getHgPath();
    }
}
