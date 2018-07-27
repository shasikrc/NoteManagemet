package com.example.note.services;

import com.example.note.dao.NoteRepository;
import com.example.note.entity.Note;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC$
 */
@Service
public class NoteService {
    
    @Autowired
    private NoteRepository noteRepo;
    
    public NoteService() {
    }
    
    public int addNote(String title, String description, LocalDateTime addedDate) {
        try {
            Note newNote = new Note();
            newNote.setTitle(title);
            newNote.setNoteBody(description);
            newNote.setAddedTime(addedDate);
            newNote.setModifiedTime(null);
        } catch (Exception ex) {
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
    
    public int removeNote(Integer id) {
        noteRepo.deleteById(id);
        return 0;
    }
}
