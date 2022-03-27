package com.example.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.db.dao.NoteDao
import com.example.room.model.NoteModel

@Database(entities = [NoteModel::class], version = 2)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao


    companion object {
        private var database: NoteDataBase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDataBase {
            return if (database == null) {
                database = Room.databaseBuilder(context, NoteDataBase::class.java, "db").build()
                database as NoteDataBase

            } else {
                database as NoteDataBase

            }
        }

    }

}

