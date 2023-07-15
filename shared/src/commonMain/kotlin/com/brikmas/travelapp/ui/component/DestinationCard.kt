package com.brikmas.travelapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.brikmas.travelapp.SharedRes
import com.brikmas.travelapp.model.Destination
import com.brikmas.travelapp.model.destinations
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun destinationSmallItem(destination: Destination) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp , top = 12.dp, end = 16.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = colorResource(SharedRes.colors.primaryColor),
                spotColor = colorResource(SharedRes.colors.primaryColor)
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(SharedRes.colors.white)),
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.width(95.dp).height(84.dp),
                painter = painterResource(SharedRes.images.destination_thumbnail),
                contentDescription = "thumbnail_destination",
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.padding(start = 14.dp)
            ) {
                Text(
                    text = destination.title,
                    color = colorResource(SharedRes.colors.textColor),
                    style = MaterialTheme.typography.titleMedium
                )
                Row(
                    modifier = Modifier.padding(top = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(SharedRes.images.ci_location),
                        contentDescription = null,
                        tint = colorResource(SharedRes.colors.primaryColor)
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = destination.location,
                        color = colorResource(SharedRes.colors.thirdTextColor),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 6.dp),
                    text = destination.description,
                    color = colorResource(SharedRes.colors.secondTextColor),
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                Row(
                    modifier = Modifier.padding(top = 9.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = destination.price,
                        color = colorResource(SharedRes.colors.textColor),
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = "/${destination.type}",
                        color = colorResource(SharedRes.colors.secondTextColor),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
fun destinationLargeItem(destination: Destination) {
    Box(
        modifier = Modifier
            .width(222.dp)
            .height(143.dp)
            .padding(start = 16.dp)
            .background(
                color = colorResource(SharedRes.colors.categoryBgColor),
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(SharedRes.images.destination_thumbnail),
            contentDescription = "thumbnail_destination",
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = destination.title,
                    color = colorResource(SharedRes.colors.white),
                    style = MaterialTheme.typography.titleSmall
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(SharedRes.images.ci_location),
                        contentDescription = null,
                        tint = colorResource(SharedRes.colors.white)
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = destination.location,
                        color = colorResource(SharedRes.colors.white),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Column(
                modifier = Modifier.padding(top = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = destination.price,
                    color = colorResource(SharedRes.colors.white),
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = "/${destination.type}",
                    color = colorResource(SharedRes.colors.white),
                    style = MaterialTheme.typography.bodySmall
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
            itemContent = { destinationSmallItem(it) }
        )
    }
}

@Composable
fun loadDestinationLargeItems(destinations: List<Destination>){
    LazyRow(
        modifier = Modifier.padding(top = 22.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = destinations,
            itemContent = { destinationLargeItem(it) }
        )
    }
}