package com.example.room.screens.start

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.room.REPO
import com.example.room.db.NoteDataBase
import com.example.room.db.repository.NoteRealization
import com.example.room.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {
    val context = application
    fun getRepo() {
        val dao = NoteDataBase.getInstance(context).getNoteDao()
        REPO = NoteRealization(dao)
    }

    fun getAllNote(): LiveData<List<NoteModel>> {
        return REPO.allNotes
    }
}