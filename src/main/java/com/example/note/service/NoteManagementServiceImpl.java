package com.example.note.service;

import com.example.note.dao.NoteRepository;
import com.example.note.entity.Note;
import com.example.note.exception.NoteManagementException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC$
 */
@Service
@Slf4j
public class NoteManagementServiceImpl implements NoteManagementService {

    private NoteRepository noteRepo;

    public NoteManagementServiceImpl() {
    }

    @Autowired
    public NoteManagementServiceImpl(NoteRepository noteRepo) {
        this.noteRepo = noteRepo;
    }

    @Override
    public void addNote(String title, String description) throws NoteManagementException {
        if(title == null || title.isEmpty()){
            throw  new IllegalArgumentException("Null or empty title.");
        }
        if(description == null || description.isEmpty()){
            throw  new IllegalArgumentException("Null or empty description.");
        }
        log.info("A new note creation request received with title {} and description {}.", title, description);
        try {
            LocalDateTime addedDate = LocalDateTime.now();
            Note newNote = new Note();
            newNote.setTitle(title);
            newNote.setBody(description);
            newNote.setCreatedDate(addedDate);
            noteRepo.save(newNote);
        } catch (Exception ex) {
            log.error("Failed to create a new note.", ex);
            throw new NoteManagementException(ex.getMessage());
        }
    }

    @Override
    public void editNote(Integer id, String title, String description) throws NoteManagementException {
        log.info("Edit note request received for id {} with title {} and descriptin {} ", id, title, description);
        try {
        LocalDateTime modifiedDate = LocalDateTime.now();
        Note modifiedNote = noteRepo.findById(id).get();
        modifiedNote.setModifiedDate(modifiedDate);
        modifiedNote.setTitle(title);
        modifiedNote.setBody(description);
        noteRepo.save(modifiedNote);
        } catch (Exception ex) {
            log.error("Failed to edit a note.", ex);
            throw new NoteManagementException(ex.getMessage());
        }
    }

    @Override
    public int removeNoteById(Integer id) {
        noteRepo.deleteById(id);
        return 0;
    }

    @Override
    public ArrayList<Note> getAllNotes() {
        ArrayList<Note> notelist = new ArrayList<>();
        noteRepo.findAll().forEach(e -> notelist.add(e));
        return notelist;
    }
}
