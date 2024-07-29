package ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import model.Destination
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.arrow_forward
import travelbuddy.composeapp.generated.resources.category
import travelbuddy.composeapp.generated.resources.home_tab
import travelbuddy.composeapp.generated.resources.menu_home
import travelbuddy.composeapp.generated.resources.popular_destination
import travelbuddy.composeapp.generated.resources.view_all
import ui.component.ChildLayout
import ui.component.LoadItemAfterSafeCast
import ui.component.NearestLocationItem
import ui.component.TitleWithViewAllItem
import ui.component.VerticalScrollLayout
import ui.component.destinationSmallItem
import ui.component.homeHeader
import ui.component.loadCategoryItems
import ui.component.loadDestinationLargeItems
import ui.viewmodel.HomeViewModel
import util.BOTTOM_NAV_SPACE

enum class HomeScreenContents {
    HEADER_SECTION,
    CATEGORY_VIEW_ALL,
    CATEGORY_SECTION,
    DESTINATION_LARGE_SECTION,
    DESTINATION_VIEW_ALL,
    NEAREST_LOCATIONS,
    DESTINATION_SMALL_SECTION,
}

data object HomeTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.home_tab)
            val icon = painterResource(Res.drawable.menu_home)

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
        Navigator(HomeScreen)
    }

}

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        HomeScreenView(navigator = navigator)
    }
}


@Composable
fun HomeScreenView(
    viewModel: HomeViewModel = viewModel { HomeViewModel() },
    navigator: Navigator
) {
    val destinations by viewModel.destinations.collectAsState()
    val categories by viewModel.categories.collectAsState()


    Surface(modifier = Modifier.fillMaxWidth().padding(bottom = BOTTOM_NAV_SPACE)) {
        var mDestinations by remember { mutableStateOf(destinations) }
        VerticalScrollLayout(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background),
            ChildLayout(
                contentType = HomeScreenContents.HEADER_SECTION.name,
                content = {
                    homeHeader()
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.CATEGORY_VIEW_ALL.name,
                content = {
                    TitleWithViewAllItem(
                        stringResource(Res.string.category),
                        stringResource(Res.string.view_all),
                        Res.drawable.arrow_forward
                    )
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.CATEGORY_SECTION.name,
                content = {
                    loadCategoryItems(categories) { category ->
                        when (category.title) {
                            "All" -> mDestinations = destinations
                            else -> mDestinations = arrayListOf<Destination>().apply {
                                addAll(destinations.filter { it.category == category })
                            }
                        }
                    }
                }
            ),

            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_LARGE_SECTION.name,
                content = {
                    loadDestinationLargeItems(
                        destinations = mDestinations,
                        checkFavorite = {
                            viewModel.checkFavorite(it)
                        },
                        addFavorite = {
                            viewModel.addFavorite(it)
                        },
                        removeFavorite = {
                            viewModel.removeFavorite(it)
                        },
                        onItemClicked = {
                            viewModel.setBottomNavBarVisible(false)
                            navigator.push(DestinationDetailScreen(it))
                        }
                    )
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_VIEW_ALL.name,
                content = {
                    TitleWithViewAllItem(
                        stringResource(Res.string.popular_destination),
                        stringResource(Res.string.view_all),
                        Res.drawable.arrow_forward
                    )
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_SMALL_SECTION.name,
                items = mDestinations,
                content = { item ->
                    LoadItemAfterSafeCast<Destination>(item) {
                        destinationSmallItem(it) {
                            viewModel.setBottomNavBarVisible(false)
                            navigator.push(DestinationDetailScreen(it))
                        }
                    }
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_VIEW_ALL.name,
                content = {
                    TitleWithViewAllItem(
                        "Nearst your location",
                        stringResource(Res.string.view_all),
                        Res.drawable.arrow_forward
                    )
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.NEAREST_LOCATIONS.name,
                content = {
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 12.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        mDestinations.forEach {
                            NearestLocationItem(it) {
                                viewModel.setBottomNavBarVisible(false)
                                navigator.push(DestinationDetailScreen(it))
                            }
                        }
                    }
                }
            )
        )
    }
}



