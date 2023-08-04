package com.brikmas.travelapp.model

import dev.icerock.moko.resources.ImageResource

data class Category(
    val id: Int,
    val title: String,
    val image: ImageResource
    )