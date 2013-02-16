package com.jg.hgsvn.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CommandLine {
    private List<String> tokens = new ArrayList<String>();

    public CommandLine() {
    }
    
    public void addToken(String token){
        tokens.add(token);
    }

    public List<String> getTokens() {
        return tokens;
    }
    
    public String[] asArray(String executable){
        String[] a = new String[tokens.size() + 1];
        a[0] = executable;
        int index = 1;
        for (String token : tokens) {
            a[index++] = token;
        }
        return a;
    }
}
