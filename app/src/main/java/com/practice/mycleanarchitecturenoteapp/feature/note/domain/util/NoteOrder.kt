package com.practice.mycleanarchitecturenoteapp.feature.note.domain.util

sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : NoteOrder(orderType)
    class Date(orderType: OrderType) : NoteOrder(orderType)
    class Colour(orderType: OrderType) : NoteOrder(orderType)

    fun copy(orderType: OrderType) =
        when (this) {
            is Title -> Title(orderType = orderType)
            is Date -> Date(orderType = orderType)
            is Colour -> Colour(orderType = orderType)
        }
}
