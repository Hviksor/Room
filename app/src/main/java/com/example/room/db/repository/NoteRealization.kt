package com.example.room.db.repository

import androidx.lifecycle.LiveData
import com.example.room.adapter.NoteAdapter
import com.example.room.db.dao.NoteDao
import com.example.room.model.NoteModel

class NoteRealization(val noteDao: NoteDao) : NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess
    }


}