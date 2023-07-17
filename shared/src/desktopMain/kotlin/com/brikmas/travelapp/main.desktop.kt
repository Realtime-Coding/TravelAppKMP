package com.brikmas.travelapp

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Desktop"

@Composable fun MainView() = CommonView()

@Preview
@Composable
fun AppPreview() {
    CommonView()
}