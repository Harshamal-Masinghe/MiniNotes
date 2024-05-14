package com.mininotes.repository

import androidx.lifecycle.LiveData
import com.mininotes.database.NoteDatabase
import com.mininotes.model.Note

class NoteRepository(private val db: NoteDatabase) {
    suspend fun insert(note: Note) = db.getNoteDao().insert(note)
    suspend fun update(note: Note) = db.getNoteDao().update(note)
    suspend fun delete(note: Note) = db.getNoteDao().delete(note)

    fun getAllNotes(): LiveData<List<Note>> = db.getNoteDao().getAllNotes()
    fun searchNotes(query: String): LiveData<List<Note>> = db.getNoteDao().searchNotes(query)
}