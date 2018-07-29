package com.example.note.services;

import com.example.note.dao.NoteRepository;
import com.example.note.entity.Note;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC$
 */
@Service
public class NoteService {

    private NoteRepository noteRepo;

    public NoteService() {
    }

    @Autowired
    public NoteService(NoteRepository noteRepo) {
        this.noteRepo = noteRepo;
    }

    public int addNote(String title, String description, LocalDateTime addedDate) {
        try {
            Note newNote = new Note();
            newNote.setTitle(title);
            newNote.setNoteBody(description);
            newNote.setAddedTime(addedDate);
            newNote.setModifiedTime(null);

            noteRepo.save(newNote);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        return 0;
    }

    public int editNote(Integer id, String title, String description, LocalDateTime modifiedDate) {
        Note modifiedNote = noteRepo.findById(id).get();
        modifiedNote.setModifiedTime(modifiedDate);
        modifiedNote.setTitle(title);
        modifiedNote.setNoteBody(description);
        noteRepo.save(modifiedNote);
        return 0;
    }

    public int removeNoteById(Integer id) {
        noteRepo.deleteById(id);
        return 0;
    }

    public ArrayList<Note> getAllNotes() {
        ArrayList<Note> notelist = new ArrayList<>();
        noteRepo.findAll().forEach(e -> notelist.add(e));
        return notelist;
    }
}
