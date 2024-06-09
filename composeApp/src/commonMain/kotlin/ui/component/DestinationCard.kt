package ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import data.FakeFavorites
import model.Destination
import util.ImageItem
import org.jetbrains.compose.resources.painterResource
import theme.White
import theme.CategoryBgColor
import theme.PrimaryColor
import theme.Red
import theme.SecondTextColor
import theme.TextColor
import theme.ThirdTextColor
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.ci_location
import travelbuddy.composeapp.generated.resources.menu_fav

@Composable
fun destinationSmallItem(
    destination: Destination,
    onItemClicked: (Destination) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp , top = 12.dp, end = 16.dp)
            .clickable { onItemClicked.invoke(destination) }
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = PrimaryColor,
                spotColor = PrimaryColor
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp),
            ) {
                ImageItem(
                    data = destination.thumbnail,
                    modifier = Modifier.width(140.dp).height(110.dp),
                )
            }
            Column(
                modifier = Modifier.padding(start = 14.dp)
            ) {
                Text(
                    text = destination.title,
                    color = TextColor,
                    style = MaterialTheme.typography.bodySmall
                )
                Row(
                    modifier = Modifier.padding(top = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(Res.drawable.ci_location),
                        contentDescription = null,
                        tint = PrimaryColor
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = destination.location,
                        color = ThirdTextColor,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 6.dp),
                    text = destination.description,
                    color = SecondTextColor,
                    style = MaterialTheme.typography.labelSmall,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                Row(
                    modifier = Modifier.padding(top = 9.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = destination.price,
                        color = TextColor,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = "/${destination.type}",
                        color = SecondTextColor,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}

@Composable
fun destinationLargeItem(
    destination: Destination,
    onItemClicked: (Destination) -> Unit
) {

    val isFav = remember { mutableStateOf(FakeFavorites.checkFavorite(destination)) }

    Card (
        modifier = Modifier
            .width(222.dp)
            .height(240.dp)
            .padding(start = 16.dp)
            .clickable { onItemClicked.invoke(destination) }
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = PrimaryColor,
                spotColor = PrimaryColor
            )
            .background(
                color = CategoryBgColor,
                shape = RoundedCornerShape(10.dp)
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = White),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Box(
                modifier = Modifier
                    .width(240.dp)
                    .height(200.dp)
                    .clickable { onItemClicked.invoke(destination) }
                    .background(
                        color = CategoryBgColor,
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.BottomStart
            ) {

                ImageItem(destination.thumbnail)

                Box(
                    modifier = Modifier.size(45.dp)
                        .padding(8.dp)
                        .background(
                            color = White,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .align(Alignment.TopEnd)
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
                    val tintColor = if (isFav.value) Red else TextColor
                    Icon(
                        modifier = Modifier.padding(6.dp),
                        painter = painterResource(Res.drawable.menu_fav),
                        tint = tintColor,
                        contentDescription = null
                    )
                }

                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 12.dp)
                ) {

                    Text(
                        text = destination.title,
                        color = White,
                        style = MaterialTheme.typography.bodySmall
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = destination.price,
                            color = White,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "/${destination.type}",
                            color = White,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.padding(start = 14.dp, end = 14.dp, top = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(Res.drawable.ci_location),
                    contentDescription = null,
                    tint = TextColor
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = destination.location,
                    color = TextColor,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
fun loadDestinationSmallItems(destinations: List<Destination>){
    LazyColumn(
        modifier = Modifier.padding(start = 0.dp, top = 22.dp, end = 0.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = destinations,
            itemContent = { destinationSmallItem(it,{}) }
        )
    }
}

@Composable
fun loadDestinationLargeItems(
    destinations: List<Destination>,
    onItemClicked: (Destination) -> Unit
){
    LazyRow(
        modifier = Modifier.padding(top = 22.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = destinations,
            itemContent = {
                destinationLargeItem(
                    destination = it,
                    onItemClicked = onItemClicked
                )
            }
        )
    }
}