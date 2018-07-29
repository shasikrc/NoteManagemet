package com.example.note.controller;

import com.example.note.entity.Note;
import com.example.note.services.NoteService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class NoteController {

    private NoteService noteServie;

    @Autowired
    public NoteController(NoteService noteServie) {
        this.noteServie = noteServie;
    }

    @PostMapping("/addnote")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addNote(@RequestParam(name = "notetitle") String title,
            @RequestParam(name = "notebody") String body,
            @RequestParam(name = "addeddate", required = false) String addedDate) {

//        DateTimeFormatter format = DateTimeFormatter.ISO_INSTANT;
//        LocalDateTime time = LocalDateTime.parse(addedDate, format);
        int result = this.noteServie.addNote(title, body, null);
        System.out.println(result + "****************************");
        System.out.println("Title : " + title + " , body :" + body + " ,date" + addedDate + " ::::::");
    }

    @GetMapping("/viewAllNotes")
    public ResponseEntity<ArrayList<Note>> getAllNotes() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity(noteServie.getAllNotes(), httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/editnote")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editnote(@RequestParam(name = "edtitle") String title,
            @RequestParam(name = "edbody") String body,
            @RequestParam(name = "modifieddate", required = false) String modifiedDate,
            @RequestParam(name = "edid") Integer id) {
        int rsult = noteServie.editNote(id, title, body, null);
        System.out.println("Title : " + title + " , body :" + body + " ,date"
                + modifiedDate + " :::::: id " + id + " &&&& " + rsult);
    }

    @GetMapping("/deletenote")
    @ResponseBody
    public int removeNote(@RequestParam(name = "noteId") String id) {
        return noteServie.removeNoteById(Integer.parseInt(id));
    }
}
