package com.example.note.service;

import com.example.note.entity.Note;
import com.example.note.exception.NoteManagementException;
import java.util.ArrayList;

/**
 * A Service to manage note in the system
 *
 * @author Charitha
 */
public interface NoteManagementService {

    /**
     * Create a new in the system
     *
     * @param title title of the note
     * @param description description of the note
     * @throws NoteManagementException if failed to create a new note in the
     * system
     */
    void addNote(String title, String description) throws NoteManagementException;

    /**
     * Edit existing note in the system
     * 
     * @param id id of the note
     * @param title title of the note
     * @param description description of the note
     * @throws NoteManagementException if failed to edit the note within giving criteria in the system
     */
    void editNote(Integer id, String title, String description) throws NoteManagementException;

    /**
     * Fetch all existing notes in the system
     * 
     * @return ArrayList of type Note
     * @throws NoteManagementException if failed to fetch notes.
     */
    ArrayList<Note> getAllNotes() throws NoteManagementException;

    /**
     * Remove a note from the system
     * 
     * @param id id of the note
     * @throws NoteManagementException if failed to delete the relevant note from the system
     */
    void removeNoteById(Integer id) throws NoteManagementException;

}
