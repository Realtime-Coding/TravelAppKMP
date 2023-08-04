package com.brikmas.travelapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brikmas.travelapp.Navigation.Route
import com.brikmas.travelapp.Navigation.Screen
import com.brikmas.travelapp.SharedRes
import com.brikmas.travelapp.data.FakeFavorites
import com.brikmas.travelapp.model.Destination
import com.brikmas.travelapp.ui.component.LoadItemAfterSafeCast
import com.brikmas.travelapp.ui.component.TitleWithViewAllItem
import com.brikmas.travelapp.ui.component.destinationSmallItem
import com.brikmas.travelapp.util.BOTTOM_NAV_SPACE
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun FavoriteScreen(routeState: MutableState<Route>) {
    Surface(modifier = Modifier.fillMaxWidth().padding(bottom = BOTTOM_NAV_SPACE)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            item {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 36.dp),
                    text = "Favorite Destinations",
                    color = colorResource(SharedRes.colors.textColor),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }
            item {
                Spacer(
                    modifier = Modifier.padding(top = 16.dp),
                )
            }
            item {
                FakeFavorites.favorites.forEach { item ->
                    LoadItemAfterSafeCast<Destination>(item) {
                        destinationSmallItem(it) {
                            routeState.value = Route(
                                screen = Screen.DestinationDetail(it),
                                prev = Screen.Favorite
                            )
                        }
                    }
                }
            }
        }
    }
}