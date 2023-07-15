package com.brikmas.travelapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.brikmas.travelapp.SharedRes
import com.brikmas.travelapp.model.Destination
import com.brikmas.travelapp.ui.component.PrimaryButton
import com.brikmas.travelapp.ui.component.TitleWithReview
import com.brikmas.travelapp.ui.component.destinationDetailHeader
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun DestinationDetailScreen(destination: Destination) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        topSection()
        contentSection(destination)
        PrimaryButton("Book Now", PaddingValues(start = 25.dp, top = 36.dp, end = 25.dp, bottom = 36.dp))
    }
}


@Composable
fun topSection() {
    Box(
        modifier = Modifier.fillMaxWidth().height(350.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = size.height/3,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient,blendMode = BlendMode.Multiply)
                    }
                },
            painter = painterResource(SharedRes.images.wallpaper1),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )
        destinationDetailHeader()
    }
}


@Composable
fun contentSection(destination: Destination) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = -40.dp)
            .background(color = colorResource(SharedRes.colors.white),shape = RoundedCornerShape(26.dp, 26.dp, 0.dp, 0.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 25.dp, top = 36.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = destination.title,
                    color = colorResource(SharedRes.colors.textColor),
                    style = MaterialTheme.typography.titleLarge
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp),
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
                        color = colorResource(SharedRes.colors.primaryColor),
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
            Column(
                modifier = Modifier.padding(top = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = destination.price,
                    color = colorResource(SharedRes.colors.textColor),
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = TextUnit(24f, TextUnitType.Sp)
                )
                Text(
                    text = "/${destination.type}",
                    color = colorResource(SharedRes.colors.secondTextColor),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Text(
            modifier = Modifier.padding(start = 25.dp, top = 18.dp, end = 25.dp),
            text = destination.description,
            color = colorResource(SharedRes.colors.secondTextColor),
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Justify
        )

        TitleWithReview("Preview", "4.8", SharedRes.images.star)

        Row(
            modifier = Modifier.padding(start = 25.dp, top = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            destination.image.forEach {
                Image(
                    modifier = Modifier.size(90.dp),
                    painter = painterResource(it),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}