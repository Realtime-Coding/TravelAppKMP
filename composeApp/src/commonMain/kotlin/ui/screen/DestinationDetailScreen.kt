package ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import theme.White
import theme.PrimaryColor
import theme.SecondTextColor
import theme.TextColor
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.ci_location
import travelbuddy.composeapp.generated.resources.star
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
            title = "Book Now",
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
        ImageItem(thumbnail.value)
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
            Column {
                Text(
                    text = destination.title,
                    color = TextColor,
                    style = MaterialTheme.typography.bodySmall
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp),
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
                        color = PrimaryColor,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
            Column(
                modifier = Modifier.padding(top = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = destination.price,
                    color = TextColor,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = TextUnit(24f, TextUnitType.Sp)
                )
                Text(
                    text = "/${destination.type}",
                    color = SecondTextColor,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        Text(
            modifier = Modifier.padding(start = 25.dp, top = 18.dp, end = 25.dp),
            text = destination.description,
            color = SecondTextColor,
            style = MaterialTheme.typography.labelSmall,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Justify
        )

        TitleWithReview("Preview", "4.8", Res.drawable.star)

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
    }
}