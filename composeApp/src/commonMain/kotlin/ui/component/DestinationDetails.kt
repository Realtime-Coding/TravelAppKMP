package ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import theme.BorderColor
import theme.TextColor
import theme.White
import theme.Yellow
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.cart_add
import travelbuddy.composeapp.generated.resources.cart_minu
import travelbuddy.composeapp.generated.resources.star


@Composable
fun DestinationDetailSubItem(label: String, Title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            color = BorderColor,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = Title,
            color = TextColor,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun DestinationDetailSubItemRatting(label: String, ratting: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            color = BorderColor,
            style = MaterialTheme.typography.bodySmall
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(14.dp),
                painter = painterResource(Res.drawable.star),
                contentDescription = null,
                tint = Yellow
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = ratting,
                color = TextColor,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun DestinationDetailSubItemDivider() {
    Spacer(
        Modifier
            .size(1.dp, height = 50.dp)
            .background(color = BorderColor, shape = RoundedCornerShape(8.dp))
    )
}


@Composable
fun DestinationDetailPersonCard() {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, top = 30.dp, end = 16.dp),
        border = BorderStroke(1.dp, BorderColor),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Number Of Pax",
                    color = TextColor,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "$80",
                    color = TextColor,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Row(
                modifier = Modifier.padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(resource = Res.drawable.cart_add),
                    contentDescription = "",
                    tint = Color.Black
                )
                Text(
                    text = "0",
                    color = TextColor,
                    style = MaterialTheme.typography.bodyMedium,
                )

                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(resource = Res.drawable.cart_minu),
                    contentDescription = "",
                    tint = Color.Black
                )
            }

        }
    }
}

@Composable
fun DestinationDetailDateItem(dates: List<String>) {
    LazyRow(
        modifier = Modifier
            .padding(start = 16.dp, top = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dates) {
            AssistChip(
                onClick = {},
                label = {
                    Text(
                        modifier = Modifier,
                        text = it,
                        style = MaterialTheme.typography.labelMedium,
                        color = TextColor,
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DestinationDetailFacilityItem(dates: List<String>) {
    FlowRow(
        modifier = Modifier
            .padding(start = 16.dp, top = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        dates.forEach {
            AssistChip(
                onClick = {},
                leadingIcon = {
                    Image(
                        modifier = Modifier.size(18.dp),
                        painter = painterResource(Res.drawable.star),
                        contentDescription = ""
                    )
                },
                label = {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelMedium,
                        color = TextColor,
                    )
                }
            )
        }
    }
}
