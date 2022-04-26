package com.practice.mycleanarchitecturenoteapp.feature.note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.util.NoteOrder
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            DefaultRadioButton(
                text = "Title",
                selected = noteOrder is NoteOrder.Title,
                isChecked = {
                    onOrderChange(NoteOrder.Title(noteOrder.orderType))
                }
            )

            DefaultRadioButton(
                text = "Date",
                selected = noteOrder is NoteOrder.Date,
                isChecked = {
                    onOrderChange(NoteOrder.Date(noteOrder.orderType))
                }
            )

            DefaultRadioButton(
                text = "Colour",
                selected = noteOrder is NoteOrder.Colour,
                isChecked = {
                    onOrderChange(NoteOrder.Colour(noteOrder.orderType))
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = noteOrder.orderType is OrderType.Ascending,
                isChecked = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                }
            )

            DefaultRadioButton(
                text = "Descending",
                selected = noteOrder.orderType is OrderType.Descending,
                isChecked = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                }
            )
        }
    }

}