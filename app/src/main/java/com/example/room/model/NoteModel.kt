package com.example.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo
    var title: String,
    @ColumnInfo
    var description: String

)