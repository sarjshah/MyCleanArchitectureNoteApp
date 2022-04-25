package com.practice.mycleanarchitecturenoteapp.feature.note.domain.usecase

import com.practice.mycleanarchitecturenoteapp.feature.note.domain.model.InvalidNoteException
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.model.Note
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.repository.NoteRepository
import javax.inject.Inject
import kotlin.jvm.Throws

class AddNote @Inject constructor(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {

        if(note.title.isBlank()) {
            throw InvalidNoteException("The Note title cannot be empty.")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("The Note content cannot be empty.")
        }

        repository.insertNote(note)
    }
}