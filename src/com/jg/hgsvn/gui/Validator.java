package com.jg.hgsvn.gui;

import java.io.File;

/**
 *
 */
public class Validator {
    
    private ToRun data;

    public Validator(ToRun data) {
        this.data = data;
    }

    public void basicValidation() throws ValidationException{
        validateWorkspace();
        validateTemplate();
    }

    private void validateTemplate() throws ValidationException {
        if(data.getTemplate() == null){
            throw new ValidationException("Please select or create a template.", "Specify template");
        }
    }

    private void validateWorkspace() throws ValidationException {
        if(data.getWorkspace() == null){
            throw new ValidationException("Please select or create a workspace.", "Specify workspace");          
        }
        if(!new File(data.getWorkspace()).isDirectory()){
            throw new ValidationException("Selected workspace is not a directory", "Invalid workspace");
        }        
    }
    
   
    
  
    

/*
    private void runProcess(Template t) {
        String[] ps = t.getHgCommandString().split("\n");

        for (String p : ps) {
            runHgProcess(t, p);
        }
    }

    private void runHgProcess(Template t, String p){

        String[] ps = p.split(" ");
        List<String> args =new ArrayList<String>();
        args.add(Main.persistence.getHgPath());
        for (String s : ps) {
            if(s.startsWith("$")){
                String param = MainFrame.right.getTemplatePanel().getParameterPanel().getParameter(s.substring(1));
                if(param == null || param.trim().equals("")){
                    JOptionPane.showConfirmDialog(MainFrame.instance, "Pleaser fill out '"+s+"'", "Missing parameter", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                args.add(param);
            }
            else{
                args.add(s);
            }

        }
        Main.printout("ARGS");

        String[] rArgs = new String[args.size()];
        int i = 0;
        for (String arg : args) {
            rArgs[i++] = arg;
        }

        try {
            Validator.runProcess2(rArgs, null);
        }
        catch (IOException e) {
            e.printStackTrace();
            Main.printout(e.getMessage());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            Main.printout(e.getMessage());
        }
    }

*/


    private boolean isEmpty(String s){
        return s == null || s.trim().length() == 0;
    }

    
    
    
}
