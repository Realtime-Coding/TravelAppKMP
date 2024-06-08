package model

import Navigation.Screen
import ui.component.Menu
import org.jetbrains.compose.resources.DrawableResource

data class MenuItem(
    val item: Menu,
    val title: String,
    val icon: DrawableResource,
    val screen: Screen,
)