package com.brikmas.travelapp.Navigation

import com.brikmas.travelapp.model.Destination

sealed interface Screen {
    object Home : Screen
    data class DestinationDetail(val destination: Destination) : Screen
}

data class Route(val screen: Screen = Screen.Home)