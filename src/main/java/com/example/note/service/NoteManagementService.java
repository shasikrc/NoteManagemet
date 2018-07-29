/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.note.service;

import com.example.note.entity.Note;
import com.example.note.exception.NoteManagementException;
import java.util.ArrayList;

/**
 * A Service to manage note in the system
 * @author RC$
 */
public interface NoteManagementService {

    /**
     * Create a new in the system
     * 
     * @param title title of the note
     * @param description description of the note
     * @throws NoteManagementException if failed to create a new note in the system
     */
    void addNote(String title, String description) throws NoteManagementException;

    void editNote(Integer id, String title, String description) throws NoteManagementException;

    ArrayList<Note> getAllNotes();

    int removeNoteById(Integer id);
    
}
