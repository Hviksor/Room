package com.example.room.screens.addNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.REPO
import com.example.room.model.NoteModel
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {
    fun insert(noteModel: NoteModel, onSuccess: () -> Unit) {
        viewModelScope.launch {
            REPO.insertNote(noteModel) {
                onSuccess
            }
        }

    }
}