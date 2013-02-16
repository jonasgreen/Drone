package com.jg.hgsvn.gui;

import com.jg.hgsvn.*;
import com.jg.hgsvn.model.*;

import java.util.*;

/**
 *
 */
public class CommandValidator {


    public List<CommandLine> validateAndCreateCommands(String rawCommand, ParameterMap paramMap) throws ValidationException {
        List<CommandLine> commandLines = new ArrayList<CommandLine>();
        String[] cmds = rawCommand.split("\n");
        for (String commandLine : cmds) {
            commandLines.add(createCommand(commandLine, paramMap));
        }

        return commandLines;
    }

    private CommandLine createCommand(String line, ParameterMap paramMap) throws ValidationException {
        List<Parameter> paramList = paramMap.getParamList();
        validateParams(paramList);


        CommandLine commandLine = new CommandLine();

        String[] tokens = line.split(" ");
        for (String token : tokens) {
            for (Parameter p : paramList) {
                String rep = "[" + p.getName() + "]";
                token = token.replace(rep, p.getValue());
            }
            commandLine.addToken(token);
        }
        return commandLine;
    }

    private void validateParams(List<Parameter> params) throws ValidationException {
        for (Parameter p : params) {
            String value = p.getValue();
            if (value == null || value.trim().equals("")) {
                throw new ValidationException("Missing value", "Please specify a '" + p.getName() + "'");
            }
        }
    }


}
