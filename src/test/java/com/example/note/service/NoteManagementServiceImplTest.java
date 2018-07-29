/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.note.service;

import com.example.note.exception.NoteManagementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author RC$
 */
public class NoteManagementServiceImplTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addNote method, of class NoteManagementServiceImpl.
     *
     * @throws com.example.note.exception.NoteManagementException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddNoteWithEmptyTitle() throws NoteManagementException {
        String title = "";
        String description = "Test Description";
        NoteManagementServiceImpl instance = new NoteManagementServiceImpl();
        instance.addNote(title, description);
    }

    /**
     * Test of addNote method, of class NoteManagementServiceImpl.
     *
     * @throws com.example.note.exception.NoteManagementException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddNoteWithNullDescription() throws NoteManagementException {
        String title = "Test Title";
        String description = null;
        NoteManagementServiceImpl instance = new NoteManagementServiceImpl();
        instance.addNote(title, description);
    }

}
