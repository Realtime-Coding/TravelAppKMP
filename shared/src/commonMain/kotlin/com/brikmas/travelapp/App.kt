package com.brikmas.travelapp

import androidx.compose.runtime.*
import com.brikmas.travelapp.theme.TravelAppTheme
import com.brikmas.travelapp.ui.screen.homeScreen
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.getImageByFileName

@Composable
internal fun App() {
    TravelAppTheme {
        homeScreen()
    }
}


fun getImageByName(name: String): ImageResource? {
    return SharedRes.images.getImageByFileName(name) ?: SharedRes.images.getImageByFileName(
        name.substringBeforeLast(".") //strips extension from filename
    )
}

expect fun getPlatformName(): String


