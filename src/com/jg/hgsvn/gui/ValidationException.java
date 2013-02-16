package com.jg.hgsvn.gui;

/**
 *
 */
public class ValidationException extends Exception{
    private static final long serialVersionUID = 8667424571022571315L;
    private String title;
    private String message;

    public ValidationException(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
