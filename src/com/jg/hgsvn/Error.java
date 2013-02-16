package com.jg.hgsvn;

/**
 *
 */
public class Error {
    public static String error = null;

    public static void append(String line) {
        if(error == null){
            error = line;
        }
        else{
            error = error + "\n" + line;
        }
    }
}
