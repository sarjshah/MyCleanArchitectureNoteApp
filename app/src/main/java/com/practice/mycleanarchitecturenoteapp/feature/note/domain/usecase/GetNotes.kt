package com.practice.mycleanarchitecturenoteapp.feature.note.domain.usecase

import com.practice.mycleanarchitecturenoteapp.feature.note.domain.repository.NoteRepository
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.util.NoteOrder
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.util.NoteOrder.Date
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.util.OrderType
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetNotes @Inject constructor(
    private val repository: NoteRepository
) {

    operator fun invoke(noteOrder: NoteOrder = Date(OrderType.Descending)) =
        repository.getNotes().map { noteList ->
            when (noteOrder.orderType) {
                OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Colour -> noteList.sortedBy { it.colour }
                        is Date -> noteList.sortedBy { it.timeStamp }
                        is NoteOrder.Title -> noteList.sortedBy { it.title }
                    }
                }
                OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Colour -> noteList.sortedByDescending { it.colour }
                        is Date -> noteList.sortedByDescending { it.timeStamp }
                        is NoteOrder.Title -> noteList.sortedByDescending { it.title }
                    }
                }
            }
        }
}