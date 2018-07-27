package com.example.note.dao;

import com.example.note.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Charitha
 */
@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {

}
