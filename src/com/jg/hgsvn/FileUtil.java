package com.jg.hgsvn;

import java.io.*;
import java.util.*;

/**
 *
 */
public class FileUtil {


    public static List<File> getHgSubDirs(File parent) {
        return getSubDirsOfType(parent, ".hg");
    }

    public static List<File> getSvnSubDirs(File parent) {
        return getSubDirsOfType(parent, ".svn");
    }


    public static List<File> getGitSubDirs(File parent) {
        return getSubDirsOfType(parent, ".git");
    }



    public static List<File> getSubDirsOfType(File parent, String type) {
        List<File> list = new ArrayList<File>();
        for (File file : parent.listFiles()) {
            if (file.isDirectory()) {
                for (File child : file.listFiles()) {
                    if (child.getName().equals(type)) {
                        list.add(file);
                    }
                }
            }
        }
        return list;
    }
}
