package com.jg.hgsvn;

import com.jg.hgsvn.gui.*;
import com.jg.hgsvn.model.*;

import java.io.*;
import java.util.*;

/**
 *
 */
public class ProcessRunner {

    private static String LOCAL_DIR_NAME = "LOCAL_DIR_NAME";


    private static void printInput(Process pr) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream(), "UTF-8"));
        String line;

        while ((line = input.readLine()) != null) {
            Main.printout("\t" + line);
        }
    }

    private static void printError(File file, Process pr) throws IOException {
        BufferedReader input;
        String line;
        input = new BufferedReader(new InputStreamReader(pr.getErrorStream(), "UTF-8"));
        StringBuilder sbError = new StringBuilder();
        while ((line = input.readLine()) != null) {
            if (!line.trim().equals("")) {
                if (sbError.length() == 0) {
                    sbError.append("Error in ").append(file.getName()).append(": ");
                }
                else {
                    sbError.append(" ");
                }
                sbError.append(line);
            }
        }
        if (sbError.length() != 0) {
            Main.printout(sbError.toString());
            Error.append(sbError.toString());
        }
    }

    private static String asString(String[] cmd) {
        StringBuilder sb = new StringBuilder();
        for (String c : cmd) {
            sb.append(c).append(" ");
        }
        return sb.toString();
    }


    public void runCommands(VersionSystem vs) throws ValidationException {
        if (!isExecutable(vs)) {
            return;
        }
        for (File f : vs.getSelectedDirs()) {
            executeCommands(f, vs.getExecutionPath(), vs.getCommandLines());
        }
    }

    private boolean isExecutable(VersionSystem vs) {
        return (vs.getCommandLines() != null && !vs.getCommandLines().isEmpty()) && (vs.getSelectedDirs() != null && !vs.getSelectedDirs().isEmpty());
    }

    private void executeCommands(final File f, final String executable, final List<CommandLine> commandLines) throws ValidationException {
        Main.printout("\nDir: " + f.getAbsolutePath());

        for (CommandLine commandLine : commandLines) {
            try {
                runProcess(commandLine.asArray(executable), f);
            }
            catch (IOException e) {
                Main.printout(e.getMessage());
                throw new ValidationException("IOException", "When executing command: " + commandLine);
            }
            catch (InterruptedException e) {
                Main.printout(e.getMessage());
                throw new ValidationException("InterruptedException", "When executing command: " + commandLine);
            }
        }


    }

    private static void runProcess(final String[] cmd, final File file) throws IOException, InterruptedException {
        String fileName = file.getName();

        String[] cmds = new String[cmd.length];
        int index = 0;
        for (String c : cmd) {
            cmds[index++] = c.replace(LOCAL_DIR_NAME, fileName);
        }

        Main.printout("\t" + asString(cmds));
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(cmds, null, file);

        printInput(pr);
        printError(file, pr);

        pr.waitFor();


    }


}
