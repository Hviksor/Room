package com.example.room.db.repository

import androidx.lifecycle.LiveData
import com.example.room.db.dao.NoteDao
import com.example.room.model.NoteModel

class NoteRealization(val dao: NoteDao) : NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = dao.getAllNote()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        dao.insert(noteModel)
        onSuccess
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        dao.delete(noteModel)
        onSuccess
    }
}