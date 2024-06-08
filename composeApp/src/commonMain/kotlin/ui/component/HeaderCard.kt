package ui.component

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
import Navigation.Route
import cafe.adriel.voyager.navigator.Navigator
import data.FakeFavorites
import model.Destination
import org.jetbrains.compose.resources.painterResource
import theme.White
import theme.craneRegular
import theme.primaryColor
import theme.red
import theme.secondTextColor
import theme.textColor
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.back
import travelbuddy.composeapp.generated.resources.ci_location
import travelbuddy.composeapp.generated.resources.humberg_icon
import travelbuddy.composeapp.generated.resources.menu_fav
import travelbuddy.composeapp.generated.resources.profile_icon

@Composable
fun homeHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(Res.drawable.humberg_icon),
            contentDescription = null
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Current Location",
                color = secondTextColor,
                fontFamily = craneRegular,
                style = MaterialTheme.typography.bodySmall
            )
            Row(
                modifier = Modifier.padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(Res.drawable.ci_location),
                    contentDescription = null,
                    tint = primaryColor
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Denpasar, Bali",
                    color = textColor,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(Res.drawable.profile_icon),
            contentDescription = null
        )
    }
}

@Composable
fun destinationDetailHeader(navigator: Navigator, destination: Destination) {
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
                   navigator.pop()
                },
            painter = painterResource(Res.drawable.back),
            contentDescription = null
        )

        Box(
            modifier = Modifier.size(36.dp)
                .background(
                    color = White,
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
            val tintColor = if (isFav.value) red else textColor
            Icon(
                modifier = Modifier.padding(6.dp),
                painter = painterResource(Res.drawable.menu_fav),
                tint = tintColor,
                contentDescription = null
            )
        }
    }
}