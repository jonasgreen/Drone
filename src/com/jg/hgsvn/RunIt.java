package com.jg.hgsvn;

import com.jg.hgsvn.gui.*;
import com.jg.hgsvn.model.*;

import java.util.*;

/**
 *
 */
public class RunIt {
    private List<VersionSystem> vsList;

    public RunIt(List<VersionSystem> vsList) {
        this.vsList = vsList;
    }

    public void run() throws ValidationException {
        long start = System.currentTimeMillis();
        Main.printout(" ******************* DRONE WARMING UP ********************************");

        ProcessRunner r = new ProcessRunner();

        for (VersionSystem vs : vsList) {
            r.runCommands(vs);
        }
        long end = System.currentTimeMillis();

        Main.printout("\n ******************* END - total time: " + ((end - start) / 1000) + " s ************************");
    }
}
