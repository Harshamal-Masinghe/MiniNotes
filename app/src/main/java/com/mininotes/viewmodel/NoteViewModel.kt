package com.mininotes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mininotes.model.Note
import com.mininotes.repository.NoteRepository

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {
    val allNotes: LiveData<List<Note>> = repository.getAllNotes()

    suspend fun insert(note: Note) {
        repository.insert(note)
    }

    suspend fun update(note: Note) {
        repository.update(note)
    }

    suspend fun delete(note: Note) {
        repository.delete(note)
    }

    fun searchNotes(searchQuery: String): LiveData<List<Note>> {
        return repository.searchNotes(searchQuery)
    }
}