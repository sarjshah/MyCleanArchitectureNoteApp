package com.practice.mycleanarchitecturenoteapp.feature.note.domain.usecase

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val insertNote: AddNote
)
