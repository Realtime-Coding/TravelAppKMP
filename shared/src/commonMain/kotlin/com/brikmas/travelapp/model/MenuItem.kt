package com.brikmas.travelapp.model

import com.brikmas.travelapp.ui.component.Menu
import dev.icerock.moko.resources.ImageResource

data class MenuItem(
    val item: Menu,
    val title: String,
    val icon: ImageResource
)