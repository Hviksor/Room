package com.example.room.db.repository

import androidx.lifecycle.LiveData
import com.example.room.db.dao.NoteDao
import com.example.room.model.NoteModel

class NoteRealization(val dao: NoteDao) : NoteRepository {
    override val allNoteModel: LiveData<List<NoteModel>>
        get() = dao.getAllNotes()


    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        dao.insert(noteModel)
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        dao.delete(noteModel)
    }
}