package com.jg.hgsvn.gui;

import com.jg.hgsvn.*;
import com.jg.hgsvn.model.*;

import java.util.*;

/**
 *
 */
public class ToRun {
    private Template template;
    private String workspace;
    private ParameterMap paramMap;
    private List<VersionSystem> vsList;

    public ToRun(List<VersionSystem> vsList, Template template, String workspace, ParameterMap paramMap) {
        this.vsList = vsList;
        this.template = template;
        this.workspace = workspace;
        this.paramMap = paramMap;
    }

    public Template getTemplate() {
        return template;
    }

    public String getWorkspace() {
        return workspace;
    }

    public ParameterMap getParamMap() {
        return paramMap;
    }

    public List<VersionSystem> getVsList() {
        return vsList;
    }
}
