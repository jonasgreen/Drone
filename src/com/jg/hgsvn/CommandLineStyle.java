package com.jg.hgsvn;

import com.jg.hgsvn.gui.*;
import com.jg.hgsvn.model.*;

import java.io.*;
import java.util.*;

/**
 *
 */
public class CommandLineStyle {


    public void run(String[] args) {
        try {
            List<VersionSystem> vsList = new ArrayList<VersionSystem>();
            if (args[0].startsWith("-")) {
                if (args.length < 2) {
                    throw new ValidationException("No template specified.", "Specifiy template after " + args[0]);
                }
                vsList.add(VersionSystem.create(args[0].substring(1)));
            }
            else{
                vsList = VersionSystem.createAll();
            }

            String templateName = vsList.size() == 1 ? args[1] : args[0];

            Template t = Main.persistence.getTemplate(templateName);
            if (t == null) {
                throw new ValidationException("Template not found", "Unable to find template '" + templateName + "'");
            }

            String workspace = System.getProperty("user.dir");
            File f = new File(workspace);
            setSelectedDirs(f, vsList);

            ParameterMap paramMap = new ParameterMap(t.getHgCommandString(), t.getSvnCommandString(), t.getGitCommandString());
            fillValuesInMap(vsList.size() == 1 ? 2 : 1, paramMap, args);

            ToRun tr = new ToRun(vsList, t, workspace, paramMap);
            new Execution(tr).execute();
        }
        catch (ValidationException e) {
            createValidationText(e);
        }
    }

    private void setSelectedDirs(File workspace, List<VersionSystem> vsList) {
        for (VersionSystem vs : vsList) {
            vs.setSelectedDirs(FileUtil.getSubDirsOfType(workspace, vs.getDirIdName()));
        }
    }


    private void fillValuesInMap(int parameterIndex, ParameterMap paramMap, String[] args) {
        int i = parameterIndex;
        for (Parameter p : paramMap.getParamList()) {
            if (args.length > i) {
                p.setValue(args[i++]);
            }
        }
    }


    private void createValidationText(ValidationException e) {
        Main.printout("\n------ " + e.getTitle().toUpperCase() + " ---------");
        Main.printout("" + e.getMessage());

    }


}
