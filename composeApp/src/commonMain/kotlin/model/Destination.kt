package model

import org.jetbrains.compose.resources.DrawableResource

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
    val image: List<String>,
    val dates: List<String>,
    val meetingPoints: List<String>,
    val facilities: List<String>,
    val via: String,
    val estimation: String
)