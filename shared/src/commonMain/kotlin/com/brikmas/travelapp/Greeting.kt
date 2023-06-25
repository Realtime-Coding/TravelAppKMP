package com.brikmas.travelapp

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.StringResource

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}