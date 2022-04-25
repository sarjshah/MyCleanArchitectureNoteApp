package com.practice.mycleanarchitecturenoteapp.feature.note.presentation.notes

import com.practice.mycleanarchitecturenoteapp.feature.note.domain.model.Note
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val order: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object toggleOrderSection: NotesEvent()
    object GoToAddNote: NotesEvent()
}
