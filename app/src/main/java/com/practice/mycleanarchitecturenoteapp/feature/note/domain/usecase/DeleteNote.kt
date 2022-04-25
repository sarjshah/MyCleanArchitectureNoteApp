package com.practice.mycleanarchitecturenoteapp.feature.note.domain.usecase

import com.practice.mycleanarchitecturenoteapp.feature.note.domain.model.Note
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNote @Inject constructor(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) = repository.deleteNote(note)

}