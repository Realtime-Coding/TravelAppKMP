package model

import org.jetbrains.compose.resources.DrawableResource

data class Category(
    val id: Int,
    val title: String,
    val image: DrawableResource
    )