package com.practice.mycleanarchitecturenoteapp.feature.note.domain.repository

import com.practice.mycleanarchitecturenoteapp.feature.note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deletNote(note: Note)
}