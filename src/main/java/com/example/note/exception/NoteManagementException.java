package com.example.note.exception;

/**
 * Custom NoteManagementException
 *
 * @author Charitha
 */
public class NoteManagementException extends Exception {

    private static final long serialVersionUID = 228440490767324425L;

    public NoteManagementException() {
        super();
    }
    
    public NoteManagementException(String message){
        super(message);
    }
    
    public NoteManagementException(String message, Throwable t){
        super(message, t);
    }

}
