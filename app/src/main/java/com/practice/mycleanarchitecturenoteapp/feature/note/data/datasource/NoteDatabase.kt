package com.practice.mycleanarchitecturenoteapp.feature.note.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

}