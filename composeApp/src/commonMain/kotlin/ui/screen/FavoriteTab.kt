package ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.TabOptions
import di.HomeScreenModelProvider
import model.Destination
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import ui.component.LoadItemAfterSafeCast
import ui.component.destinationSmallItem
import theme.TextColor
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.fav_tab
import travelbuddy.composeapp.generated.resources.favorite_destination
import travelbuddy.composeapp.generated.resources.menu_fav
import ui.component.Tabx
import ui.viewmodel.HomeScreenModel
import util.BOTTOM_NAV_SPACE

data object FavoriteTab : Tabx {
    override fun defaultTitle(): StringResource = Res.string.fav_tab
    override fun defaultIcon(): DrawableResource = Res.drawable.menu_fav

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.fav_tab)
            val icon = painterResource(Res.drawable.menu_fav)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(FavoriteScreen)
    }
}

object FavoriteScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = HomeScreenModelProvider.homeScreenModel
        val navigator = LocalNavigator.currentOrThrow
        FavoriteScreenView(navigator = navigator, viewModel = screenModel)
    }
}


@Composable
fun FavoriteScreenView(
    navigator: Navigator,
    viewModel: HomeScreenModel,
) {
    val favorites by viewModel.favorites.collectAsState()

    Surface(modifier = Modifier.fillMaxWidth().padding(bottom = BOTTOM_NAV_SPACE)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            item {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 36.dp),
                    text = stringResource(Res.string.favorite_destination),
                    color = TextColor,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )
            }
            item {
                Spacer(
                    modifier = Modifier.padding(top = 16.dp),
                )
            }
            item {
                favorites.forEach { item ->
                    LoadItemAfterSafeCast<Destination>(item) {
                        destinationSmallItem(it) {
                            viewModel.setBottomNavBarVisible(false)
                            navigator.push(DestinationDetailScreen(it))
                        }
                    }
                }
            }
        }
    }
}