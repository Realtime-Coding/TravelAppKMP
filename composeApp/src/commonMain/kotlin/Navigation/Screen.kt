package Navigation

import model.Destination

sealed interface Screen {
    object Home : Screen
    data class DestinationDetail(val destination: Destination) : Screen

    object Favorite : Screen
    object Cart : Screen
    object Profile : Screen
}