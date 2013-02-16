package com.jg.hgsvn;


import com.jg.hgsvn.gui.*;
import com.jg.hgsvn.model.*;

import javax.swing.*;
import java.util.*;

/**
 *
 */
public class Execution {
    private ToRun data;

    public Execution(ToRun data) {
        this.data = data;
    }

    public void execute() throws ValidationException {
        new Validator(data).basicValidation();

        for (VersionSystem vs : data.getVsList()) {
            String commandString = vs.getTemplateCommandString(data.getTemplate());
            if(!isEmpty(commandString)){
                vs.validateExcecutionPath();
                vs.setCommandLines(new CommandValidator().validateAndCreateCommands(commandString, data.getParamMap()));
            }
        }

        runIt(data.getVsList());
    }

    private void runIt(final List<VersionSystem> vsList) throws ValidationException {
        Error.error = null;
        if (MainFrame.instance != null) {
            SwingWorker<String, Object> w = new SwingWorker<String, Object>() {
                @Override
                protected String doInBackground() throws Exception {
                    RunIt r = new RunIt(vsList);
                    r.run();
                    printError();
                    MainFrame.instance.toFront();
                    return null;
                }
            };
            w.execute();
        }
        else {
            RunIt r = new RunIt(vsList);
            r.run();
            printError();
        }


    }

    private void printError() {
        if(Error.error != null && !Error.error.trim().equals("")){
            Main.printout("ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR");
            Main.printout(Error.error);
            Main.printout("-----------------------------------------------");
        }
        Main.printout("\n\n\n");
        Error.error = null;
    }


    private boolean isEmpty(String s) {
        return s == null || s.trim().equals("");
    }

}
