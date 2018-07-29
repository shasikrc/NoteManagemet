package com.example.note.controller;

import com.example.note.entity.Note;
import com.example.note.exception.NoteManagementException;
import com.example.note.service.NoteManagementService;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Charitha
 */
@Controller
@Slf4j
public class NoteController {

    private NoteManagementService noteServie;

    @Autowired
    public NoteController(NoteManagementService noteServie) {
        this.noteServie = noteServie;
    }

    @PostMapping("/addnote")
    public ResponseEntity addNote(@RequestParam(name = "notetitle") String title,
            @RequestParam(name = "notebody") String body) {        
        try {
            this.noteServie.addNote(title, body);
        } catch (NoteManagementException ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/viewAllNotes")
    public ResponseEntity<ArrayList<Note>> getAllNotes() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(noteServie.getAllNotes(), httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/editnote")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity editnote(@RequestParam(name = "edtitle") String title,
            @RequestParam(name = "edbody") String body,
            @RequestParam(name = "edid") Integer id) {
        try {
            noteServie.editNote(id, title, body);
        } catch (NoteManagementException ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/deletenote")
    @ResponseBody
    public int removeNote(@RequestParam(name = "noteId") String id) {
        return noteServie.removeNoteById(Integer.parseInt(id));
    }
}
