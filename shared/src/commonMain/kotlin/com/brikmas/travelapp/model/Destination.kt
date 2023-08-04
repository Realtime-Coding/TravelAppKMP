package com.brikmas.travelapp.model

data class Destination(
    val id: Int,
    val thumbnail: String,
    val title: String,
    val description: String,
    val rating: Float,
    val location: String,
    val price: String,
    val type: String,
    val category: Category,
    val image: List<String>
)