package com.brikmas.travelapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brikmas.travelapp.Navigation.Route
import com.brikmas.travelapp.Navigation.Screen
import com.brikmas.travelapp.SharedRes
import com.brikmas.travelapp.data.FakeFavorites
import com.brikmas.travelapp.model.Destination
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.fontFamilyResource
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun homeHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(SharedRes.images.humberg_icon),
            contentDescription = null
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Current Location",
                color = colorResource(SharedRes.colors.secondTextColor),
                fontFamily = fontFamilyResource(SharedRes.fonts.sf_pro_regular.sf_pro_regular),
                style = MaterialTheme.typography.titleSmall
            )
            Row(
                modifier = Modifier.padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(SharedRes.images.ci_location),
                    contentDescription = null,
                    tint = colorResource(SharedRes.colors.primaryColor)
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Denpasar, Bali",
                    color = colorResource(SharedRes.colors.textColor),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(SharedRes.images.profile_icon),
            contentDescription = null
        )
    }
}

@Composable
fun destinationDetailHeader(routeState: MutableState<Route>, destination: Destination) {
    val isFav = remember { mutableStateOf(FakeFavorites.checkFavorite(destination)) }
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .size(36.dp)
                .clickable {
                    routeState.value = routeState.value.copy(
                        screen = routeState.value.prev ?: routeState.value.screen
                    )
                },
            painter = painterResource(SharedRes.images.back),
            contentDescription = null
        )

        Box(
            modifier = Modifier.size(36.dp)
                .background(
                    color = colorResource(SharedRes.colors.white),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable {
                    if (isFav.value) {
                        FakeFavorites.removeFavorite(destination)
                        isFav.value = false
                    } else {
                        FakeFavorites.addFavorite(destination)
                        isFav.value = true
                    }
                }
        ) {
            val tintColor = if (isFav.value) SharedRes.colors.red else SharedRes.colors.textColor
            Icon(
                modifier = Modifier.padding(6.dp),
                painter = painterResource(SharedRes.images.menu_fav),
                tint = colorResource(tintColor),
                contentDescription = null
            )
        }
    }
}