package com.brikmas.travelapp

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable

class DesktopPlatform: Platform {
    override val name: String = ""
}

actual fun getPlatform(): Platform = DesktopPlatform()