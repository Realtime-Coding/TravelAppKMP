package ui.component.article

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import model.Article
import org.jetbrains.compose.resources.painterResource
import theme.Red
import theme.TextColor
import theme.White
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.back
import travelbuddy.composeapp.generated.resources.ci_location
import travelbuddy.composeapp.generated.resources.menu_fav
import util.ImageItem

@Composable
fun ArticleHeader(
    navigator: Navigator,
    article: Article,
    thumbnail: MutableState<String>,
    checkFavorite: (Article) -> Boolean,
    addFavorite: (Article) -> Unit,
    removeFavorite: (Article) -> Unit,
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 60.dp, end = 16.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = article.title,
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
                        text = article.location,
                        color = White,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

            }
        }
        ArticleHeaderTitleBar(
            navigator,
            article,
            checkFavorite,
            addFavorite,
            removeFavorite,
            updateBottomNavBarVisible
        )
    }
}

@Composable
fun ArticleHeaderTitleBar(
    navigator: Navigator,
    article: Article,
    checkFavorite: (Article) -> Boolean,
    addFavorite: (Article) -> Unit,
    removeFavorite: (Article) -> Unit,
    updateBottomNavBarVisible: () -> Unit
) {
    val isFav = remember { mutableStateOf(checkFavorite(article)) }
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
    }
}