package ui.component.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Article
import org.jetbrains.compose.resources.painterResource
import theme.Black
import theme.BorderColor
import theme.PrimaryColor
import theme.Red
import theme.TextColor
import theme.White
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.article_fav_icon
import travelbuddy.composeapp.generated.resources.article_share_icon
import travelbuddy.composeapp.generated.resources.fake_author
import travelbuddy.composeapp.generated.resources.menu_fav
import travelbuddy.composeapp.generated.resources.star

@Composable
fun ArticleBodyHeader(
    modifier: Modifier,
    article: Article,
    onFavourite: (Article) -> Unit,
    onShare: (Article) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(article.authorImage),
                contentDescription = ""
            )
            Text(
                modifier = Modifier
                    .background(color = White, shape = RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp),
                text = article.authorName,
                color = BorderColor,
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .background(color = White, shape = RoundedCornerShape(4.dp)),
                text = article.publishedDate,
                color = BorderColor,
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                modifier = Modifier
                    .background(color = PrimaryColor, shape = RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                text = article.type,
                color = White,
                style = MaterialTheme.typography.displayMedium
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val tintColor = if (true) Red else TextColor
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(Res.drawable.article_fav_icon),
                contentDescription = "",
                tint = tintColor,
            )
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(Res.drawable.article_share_icon),
                contentDescription = "",
                tint = Black
            )
        }
    }
}