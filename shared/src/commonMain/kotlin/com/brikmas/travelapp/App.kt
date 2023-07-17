package com.brikmas.travelapp

import androidx.compose.runtime.*
import com.brikmas.travelapp.Navigation.Route
import com.brikmas.travelapp.Navigation.Screen
import com.brikmas.travelapp.theme.TravelAppTheme
import com.brikmas.travelapp.ui.screen.DestinationDetailScreen
import com.brikmas.travelapp.ui.screen.HomeScreen

@Composable
internal fun CommonView() {
    TravelAppTheme {
        val routeState = remember { mutableStateOf(Route()) }
        when (val state = routeState.value.screen) {
            is Screen.DestinationDetail -> DestinationDetailScreen(
                routeState = routeState,
                destination = state.destination
            )
            Screen.Home -> HomeScreen(routeState = routeState)
        }
    }
}
expect fun getPlatformName(): String


