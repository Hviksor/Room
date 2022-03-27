package com.example.room.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.room.REPOSITORY
import com.example.room.db.NoteDataBase
import com.example.room.db.repository.NoteRealization
import com.example.room.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {
    val context = application
    fun getDatabase() {
        val dao = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(dao)
    }
    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}