package ui.component.article

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import theme.PrimaryColor
import theme.White
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.star
import util.ImageItem

@Composable
fun ArticleOther(modifier: Modifier, article: Article, onClick: (Article) -> Unit) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick.invoke(article) }
    ) {
        Card(
            border = BorderStroke(1.dp, BorderColor),
            elevation = CardDefaults.cardElevation(),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = article.title,
                        color = Black,
                        style = MaterialTheme.typography.bodyMedium
                    )
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
                    }
                }
                ImageItem(
                    modifier = Modifier.width(110.dp).height(85.dp),
                    data = article.thumbnail
                )
            }
        }
    }
}