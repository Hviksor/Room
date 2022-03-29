package com.example.room.screens.addNote

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.REPO
import com.example.room.db.NoteDataBase
import com.example.room.db.repository.NoteRealization
import com.example.room.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess: () -> Unit) {
        viewModelScope.launch (Dispatchers.IO){
            REPO.insertNote(noteModel) { onSuccess}

        }
    }


}