package com.brikmas.travelapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.brikmas.travelapp.Navigation.Route
import com.brikmas.travelapp.Navigation.Screen
import com.brikmas.travelapp.SharedRes
import com.brikmas.travelapp.model.Destination
import com.brikmas.travelapp.model.categories
import com.brikmas.travelapp.model.destinations
import com.brikmas.travelapp.ui.component.ChildLayout
import com.brikmas.travelapp.ui.component.LoadItemAfterSafeCast
import com.brikmas.travelapp.ui.component.TitleWithViewAllItem
import com.brikmas.travelapp.ui.component.VerticalScrollLayout
import com.brikmas.travelapp.ui.component.destinationSmallItem
import com.brikmas.travelapp.ui.component.homeHeader
import com.brikmas.travelapp.ui.component.loadCategoryItems
import com.brikmas.travelapp.ui.component.loadDestinationLargeItems

enum class HomeScreenContents{
    HEADER_SECTION,
    CATEGORY_VIEW_ALL,
    CATEGORY_SECTION,
    DESTINATION_LARGE_SECTION,
    DESTINATION_VIEW_ALL,
    DESTINATION_SMALL_SECTION,
}
@Composable
fun HomeScreen(routeState: MutableState<Route>){
    Surface(modifier = Modifier.fillMaxWidth()) {

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
                    TitleWithViewAllItem("Category", "View All", SharedRes.images.arrow_forward)
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.CATEGORY_SECTION.name,
                content = { item ->
                    loadCategoryItems(categories)
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_LARGE_SECTION.name,
                content = { item ->
                    loadDestinationLargeItems(destinations) {
                        routeState.value = Route(
                            screen = Screen.DestinationDetail(it)
                        )
                    }
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_VIEW_ALL.name,
                content = {
                    TitleWithViewAllItem("Popular Destination", "View All", SharedRes.images.arrow_forward)
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_SMALL_SECTION.name,
                items = destinations,
                content = { item ->
                    LoadItemAfterSafeCast<Destination>(item) {
                        destinationSmallItem(it) {
                            routeState.value = Route(
                                screen = Screen.DestinationDetail(it)
                            )
                        }
                    }
                }
            ),
        )
    }
}