package com.example.room.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.REPO
import com.example.room.model.NoteModel
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    fun delete(noteModel: NoteModel, onSuccess: () -> Unit) {
        viewModelScope.launch {
            REPO.deleteNote(noteModel) {
                onSuccess
            }

        }
    }
}