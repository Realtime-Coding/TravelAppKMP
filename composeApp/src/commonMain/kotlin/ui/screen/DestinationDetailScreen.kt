package ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import model.Destination
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import theme.BorderColor
import theme.White
import theme.PrimaryColor
import theme.ReviewBodyBg
import theme.SecondTextColor
import theme.TextColor
import theme.Yellow
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.cart_add
import travelbuddy.composeapp.generated.resources.cart_minu
import travelbuddy.composeapp.generated.resources.choose_date
import travelbuddy.composeapp.generated.resources.choose_meeting_point
import travelbuddy.composeapp.generated.resources.ci_location
import travelbuddy.composeapp.generated.resources.estimation
import travelbuddy.composeapp.generated.resources.facilities
import travelbuddy.composeapp.generated.resources.preview
import travelbuddy.composeapp.generated.resources.ratting
import travelbuddy.composeapp.generated.resources.star
import travelbuddy.composeapp.generated.resources.type
import travelbuddy.composeapp.generated.resources.via
import ui.component.DestinationDetailDateItem
import ui.component.DestinationDetailFacilityItem
import ui.component.DestinationDetailPersonCard
import ui.component.DestinationDetailSubItem
import ui.component.DestinationDetailSubItemDivider
import ui.component.DestinationDetailSubItemRatting
import ui.component.PrimaryButton
import ui.component.TitleWithReview
import ui.component.destinationDetailHeader
import ui.viewmodel.HomeViewModel
import util.BOTTOM_NAV_SPACE
import util.ImageItem

data class DestinationDetailScreen(val destination: Destination) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        DestinationDetailScreenView(navigator, destination)
    }
}

@Composable
fun DestinationDetailScreenView(
    navigator: Navigator,
    destination: Destination,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel { HomeViewModel() },
) {
    val rememberThumbnail = remember { mutableStateOf(destination.thumbnail) }
    Column(
        modifier = Modifier
            .padding(bottom = BOTTOM_NAV_SPACE)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        topSection(
            navigator,
            destination,
            rememberThumbnail,
            checkFavorite = {
                viewModel.checkFavorite(it)
            },
            addFavorite = {
                viewModel.addFavorite(it)
            },
            removeFavorite = {
                viewModel.removeFavorite(it)
            },
            updateBottomNavBarVisible = {
                viewModel.setBottomNavBarVisible(true)
            }
        )
        contentSection(destination) {
            rememberThumbnail.value = it
        }
        PrimaryButton(
            title = "Add to Cart",
            paddingValues = PaddingValues(start = 25.dp, top = 36.dp, end = 25.dp, bottom = 36.dp),
            onClick = { viewModel.addToCart(destination) }
        )
    }
}


@Composable
fun topSection(
    navigator: Navigator,
    destination: Destination,
    thumbnail: MutableState<String>,
    checkFavorite: (Destination) -> Boolean,
    addFavorite: (Destination) -> Unit,
    removeFavorite: (Destination) -> Unit,
    updateBottomNavBarVisible: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth().height(350.dp)
    ) {
        Box {
            ImageItem(
                data = thumbnail.value,
                modifier = Modifier
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(
                                Brush.verticalGradient(
                                    0.4f to Color.Black.copy(alpha = 0F),
                                    1F to Color.Black
                                )
                            )
                        }
                    }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 60.dp, end = 16.dp)
                    .align(Alignment.BottomStart),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = destination.title,
                        color = White,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(
                        modifier = Modifier.padding(top = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(18.dp),
                            painter = painterResource(Res.drawable.ci_location),
                            contentDescription = null,
                            tint = White
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = destination.location,
                            color = White,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                Column(
                    modifier = Modifier.padding(top = 4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = destination.price,
                        color = White,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = TextUnit(24f, TextUnitType.Sp)
                    )
                    Text(
                        text = "/${destination.type}",
                        color = White,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
        destinationDetailHeader(
            navigator,
            destination,
            checkFavorite,
            addFavorite,
            removeFavorite,
            updateBottomNavBarVisible
        )
    }
}


@Composable
fun contentSection(destination: Destination, onImageClicked: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = -40.dp)
            .background(
                color = White,
                shape = RoundedCornerShape(26.dp, 26.dp, 0.dp, 0.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 25.dp, top = 36.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DestinationDetailSubItemRatting(stringResource(Res.string.ratting), destination.rating.toString())
            DestinationDetailSubItemDivider()
            DestinationDetailSubItem(stringResource(Res.string.type), destination.type)
            DestinationDetailSubItemDivider()
            DestinationDetailSubItem(stringResource(Res.string.estimation), destination.estimation)
            DestinationDetailSubItemDivider()
            DestinationDetailSubItem(stringResource(Res.string.via), destination.via)
        }

        Text(
            modifier = Modifier.padding(start = 25.dp, top = 18.dp, end = 25.dp),
            text = destination.description,
            color = SecondTextColor,
            style = MaterialTheme.typography.labelSmall,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Justify
        )

        Text(
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 36.dp, end = 16.dp),
            text = stringResource(Res.string.preview),
            color = TextColor,
            style = MaterialTheme.typography.bodySmall
        )

        LazyRow(
            modifier = Modifier.padding(start = 25.dp, top = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(items = destination.image) { index, item ->
                ImageItem(
                    data = item,
                    modifier = Modifier.size(90.dp).clickable {
                        onImageClicked.invoke(item)
                    }
                )
            }
        }

        Text(
            modifier = Modifier.padding(start = 16.dp, top = 30.dp),
            text = stringResource(Res.string.choose_date),
            color = TextColor,
            style = MaterialTheme.typography.bodyMedium
        )

        DestinationDetailDateItem(destination.dates)

        Text(
            modifier = Modifier.padding(start = 16.dp, top = 30.dp),
            text = stringResource(Res.string.choose_meeting_point),
            color = TextColor,
            style = MaterialTheme.typography.bodyMedium
        )

        DestinationDetailDateItem(destination.meetingPoints)

        DestinationDetailPersonCard()

        Text(
            modifier = Modifier.padding(start = 16.dp, top = 30.dp),
            text = stringResource(Res.string.facilities),
            color = TextColor,
            style = MaterialTheme.typography.bodyMedium
        )

        DestinationDetailFacilityItem(destination.facilities)

    }
}
