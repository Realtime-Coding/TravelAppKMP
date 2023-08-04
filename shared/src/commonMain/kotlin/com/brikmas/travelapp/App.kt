package com.brikmas.travelapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.brikmas.travelapp.Navigation.Route
import com.brikmas.travelapp.Navigation.Screen
import com.brikmas.travelapp.theme.TravelAppTheme
import com.brikmas.travelapp.ui.component.BottomMenuBar
import com.brikmas.travelapp.ui.component.Menu
import com.brikmas.travelapp.ui.component.menuItems
import com.brikmas.travelapp.ui.screen.CartScreen
import com.brikmas.travelapp.ui.screen.DestinationDetailScreen
import com.brikmas.travelapp.ui.screen.FavoriteScreen
import com.brikmas.travelapp.ui.screen.HomeScreen
import com.brikmas.travelapp.ui.screen.ProfileScreen
import com.brikmas.travelapp.util.AnimateVisibility

@Composable
internal fun CommonView() {
    TravelAppTheme {
        var visible by remember { mutableStateOf(true) }
        val routeState = remember { mutableStateOf(Route(Screen.Home)) }
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            when (val state = routeState.value.screen) {
                is Screen.Home -> {
                    visible = true
                    HomeScreen(routeState = routeState)
                }
                is Screen.Favorite -> {
                    visible = true
                    FavoriteScreen(routeState = routeState)
                }
                is Screen.Cart -> {
                    visible = true
                    CartScreen(routeState = routeState)
                }
                is Screen.Profile -> {
                    visible = true
                    ProfileScreen(routeState = routeState)
                }
                is Screen.DestinationDetail -> {
                    visible = false
                    DestinationDetailScreen(
                        routeState = routeState,
                        destination = state.destination
                    )
                }
            }
            AnimateVisibility(
                visible = visible,
                modifier = Modifier
                    .wrapContentSize(Alignment.BottomStart)
            ) {
                BottomMenuBar(menuItems = menuItems, route = routeState) {
                    when (it.item) {
                        Menu.HOME -> routeState.value = Route(screen = Screen.Home)
                        Menu.FAVORITE -> routeState.value = Route(screen = Screen.Favorite)
                        Menu.CART -> routeState.value = Route(screen = Screen.Cart)
                        Menu.PROFILE -> routeState.value = Route(screen = Screen.Profile)
                    }
                }
            }
        }
    }
}

expect fun getPlatformName(): String


