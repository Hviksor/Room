package com.example.room.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.room.REPOSITORY
import com.example.room.db.NoteDataBase
import com.example.room.db.dao.NoteDao
import com.example.room.db.repository.NoteRealization
import com.example.room.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {
    val context = application

    fun getRepository() {
        val dao = NoteDataBase.getInstance(context).getDao()
        REPOSITORY = NoteRealization(dao)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}