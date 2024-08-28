package ui.component.article


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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import model.Destination
import org.jetbrains.compose.resources.painterResource
import theme.Black
import theme.BorderColor
import theme.Red
import theme.TextColor
import theme.White
import theme.Yellow
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.article_fav_icon
import travelbuddy.composeapp.generated.resources.cart_add
import travelbuddy.composeapp.generated.resources.cart_icon
import travelbuddy.composeapp.generated.resources.cart_minu
import travelbuddy.composeapp.generated.resources.ci_location
import travelbuddy.composeapp.generated.resources.menu_fav
import travelbuddy.composeapp.generated.resources.star
import util.BOTTOM_NAV_SPACE
import util.ImageItem

@Composable
fun ArticleDestination(
    modifier: Modifier,
    destination: Destination,
    onDelete: () -> Unit,
    onClickBook: (Destination) -> Unit,
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        Card(
            border = BorderStroke(1.dp, BorderColor),
            elevation = CardDefaults.cardElevation(),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row {
                    ImageItem(
                        modifier = Modifier.width(80.dp).height(70.dp),
                        data = destination.thumbnail
                    )
                    Column(
                        modifier = Modifier.padding(start = 8.dp, end = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = destination.title,
                                color = TextColor,
                                style = MaterialTheme.typography.labelMedium,
                            )
                            Icon(
                                modifier = Modifier.size(18.dp),
                                painter = painterResource(Res.drawable.article_fav_icon),
                                contentDescription = "",
                                tint = Red,
                            )
                        }
                        Text(
                            modifier = Modifier
                                .border(1.dp, BorderColor, RoundedCornerShape(4.dp))
                                .padding(horizontal = 8.dp, vertical = 2.dp),
                            text = "Hiking",
                            color = Black,
                            style = MaterialTheme.typography.labelSmall
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                modifier = Modifier,
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
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    modifier = Modifier.size(14.dp),
                                    painter = painterResource(Res.drawable.star),
                                    contentDescription = null,
                                    tint = Yellow
                                )
                                Text(
                                    modifier = Modifier.padding(start = 4.dp),
                                    text = destination.rating.toString(),
                                    color = Black,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }

                    }
                }

                Text(
                    modifier = Modifier
                        .padding(start = 32.dp, top = 28.dp, end = 32.dp)
                        .fillMaxWidth()
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(50.dp))
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    text = "Booking",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelMedium,
                    color = TextColor,
                )
            }
        }
    }
}