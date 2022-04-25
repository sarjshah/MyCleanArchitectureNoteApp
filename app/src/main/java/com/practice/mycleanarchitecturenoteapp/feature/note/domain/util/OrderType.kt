package com.practice.mycleanarchitecturenoteapp.feature.note.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending: OrderType()
}
