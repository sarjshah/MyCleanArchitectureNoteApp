package com.practice.mycleanarchitecturenoteapp.feature.note.data.repository

import com.practice.mycleanarchitecturenoteapp.feature.note.data.datasource.NoteDao
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.model.Note
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> = dao.getNotes()

    override suspend fun getNoteById(id: Int): Note? = dao.getNoteById(id)

    override suspend fun insertNote(note: Note) = dao.insertNote(note)

    override suspend fun deletNote(note: Note) = dao.deleteNote(note)
}