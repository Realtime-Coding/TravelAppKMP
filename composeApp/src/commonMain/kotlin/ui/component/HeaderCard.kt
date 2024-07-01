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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import model.Destination
import org.jetbrains.compose.resources.painterResource
import theme.White
import theme.craneRegular
import theme.PrimaryColor
import theme.Red
import theme.SecondTextColor
import theme.TextColor
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
                color = SecondTextColor,
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
                    tint = PrimaryColor
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Denpasar, Bali",
                    color = TextColor,
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
fun destinationDetailHeader(
    navigator: Navigator,
    destination: Destination,
    checkFavorite: (Destination) -> Boolean,
    addFavorite: (Destination) -> Unit,
    removeFavorite: (Destination) -> Unit,
    updateBottomNavBarVisible: () -> Unit
) {
    val isFav = remember { mutableStateOf(checkFavorite(destination)) }
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .size(36.dp)
                .clickable {
                    updateBottomNavBarVisible.invoke()
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
                        removeFavorite(destination)
                        isFav.value = false
                    } else {
                        addFavorite(destination)
                        isFav.value = true
                    }
                }
        ) {
            val tintColor = if (isFav.value) Red else TextColor
            Icon(
                modifier = Modifier.padding(6.dp),
                painter = painterResource(Res.drawable.menu_fav),
                tint = tintColor,
                contentDescription = null
            )
        }
    }
}