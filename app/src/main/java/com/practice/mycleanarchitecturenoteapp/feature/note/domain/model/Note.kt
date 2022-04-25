package com.practice.mycleanarchitecturenoteapp.feature.note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.practice.mycleanarchitecturenoteapp.feature.ui.theme.BabyBlue
import com.practice.mycleanarchitecturenoteapp.feature.ui.theme.LightGreen
import com.practice.mycleanarchitecturenoteapp.feature.ui.theme.RedOrange
import com.practice.mycleanarchitecturenoteapp.feature.ui.theme.RedPink
import com.practice.mycleanarchitecturenoteapp.feature.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val colour: Int,
    @PrimaryKey
    val id: Int? = null
) {
    companion object {
        val noteColours = listOf(RedOrange, RedPink, BabyBlue, Violet, LightGreen)
    }
}

class InvalidNoteException(message: String): Exception(message)
