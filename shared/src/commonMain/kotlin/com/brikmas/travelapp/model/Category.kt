package com.brikmas.travelapp.model

import com.brikmas.travelapp.SharedRes
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource

data class Category(
    val id: Int,
    val title: String,
    val image: ImageResource
    )

val categories = arrayListOf<Category>().apply {
    add(Category(1, "Mountain", SharedRes.images.category1))
    add(Category(2, "Waterfall", SharedRes.images.category2))
    add(Category(3, "River", SharedRes.images.category3))
    add(Category(4, "Lake", SharedRes.images.category4))
}