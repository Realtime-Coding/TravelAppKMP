package ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Article
import org.jetbrains.compose.resources.painterResource
import theme.Black
import theme.BorderColor
import theme.White
import util.ImageItem

@Composable
fun ArticleCard(modifier: Modifier, article: Article, onClick: (Article) -> Unit) {
    Card(
        modifier = modifier
            .clickable { onClick.invoke(article) }
            .padding(start = 16.dp, top = 8.dp, end = 16.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, BorderColor),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(containerColor = White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            ImageItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(305.dp)
                    .height(135.dp),
                data = article.thumbnail,
                shape = RoundedCornerShape(0.dp)
            )
            Text(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp),
                text = article.title,
                color = Black,
                style = MaterialTheme.typography.bodyMedium
            )
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(article.authorImage),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .background(color = White, shape = RoundedCornerShape(4.dp))
                        .padding(horizontal = 4.dp),
                    text = article.authorName,
                    color = BorderColor,
                    style = MaterialTheme.typography.displayMedium
                )
            }
            Text(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)
                    .background(color = White, shape = RoundedCornerShape(4.dp)),
                text = article.publishedDate,
                color = BorderColor,
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}