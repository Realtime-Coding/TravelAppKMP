package ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.Destination
import org.jetbrains.compose.resources.painterResource
import theme.BorderColor
import theme.TextColor
import theme.White
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.cart_add
import travelbuddy.composeapp.generated.resources.cart_icon
import travelbuddy.composeapp.generated.resources.cart_minu
import travelbuddy.composeapp.generated.resources.menu_fav
import util.BOTTOM_NAV_SPACE
import util.ImageItem

@Composable
fun CartCard(
    destination: Destination,
    onDelete: () -> Unit,
    onClickBook: (Destination) -> Unit,
) {
    val quantity = remember { mutableStateOf(1) }

    Surface(modifier = Modifier.fillMaxWidth().padding(bottom = BOTTOM_NAV_SPACE)) {
        Card(
            modifier = Modifier
                .padding(start = 16.dp, top = 12.dp, end = 16.dp),
            border = BorderStroke(1.dp, BorderColor),
            elevation = CardDefaults.cardElevation(),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(resource = Res.drawable.cart_icon),
                        contentDescription = ""
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = destination.location,
                                color = TextColor,
                                style = MaterialTheme.typography.bodySmall,
                            )
                            Text(
                                modifier = Modifier.padding(top = 2.dp),
                                text = "2 Feb 2014",
                                color = TextColor,
                                style = MaterialTheme.typography.labelSmall,
                            )
                        }
                        Image(
                            painter = painterResource(resource = Res.drawable.menu_fav),
                            contentDescription = ""
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = BorderColor)
                )
                Row(
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    ImageItem(
                        modifier = Modifier.width(80.dp).height(70.dp),
                        data = destination.thumbnail
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.padding(start = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = destination.title,
                                color = TextColor,
                                style = MaterialTheme.typography.bodySmall,
                            )

                            Row(
                                modifier = Modifier.padding(top = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clickable {
                                            quantity.value += 1
                                        },
                                    painter = painterResource(resource = Res.drawable.cart_add),
                                    contentDescription = "",
                                    tint = Color.Black
                                )
                                Text(
                                    text = "${quantity.value}",
                                    color = TextColor,
                                    style = MaterialTheme.typography.bodySmall,
                                )

                                Icon(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clickable {
                                            if (quantity.value > 1)
                                                quantity.value -= 1
                                        },
                                    painter = painterResource(resource = Res.drawable.cart_minu),
                                    contentDescription = "",
                                    tint = Color.Black
                                )
                            }
                            Text(
                                text = "$${quantity.value * destination.price.substring(1).toInt()}",
                                color = TextColor,
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                        Text(
                            modifier = Modifier
                                .border(1.dp, Color.Black, shape = RoundedCornerShape(50.dp))
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            text = "Booking",
                            style = MaterialTheme.typography.bodySmall,
                            color = TextColor,
                        )
                    }
                }
            }
        }
    }
}