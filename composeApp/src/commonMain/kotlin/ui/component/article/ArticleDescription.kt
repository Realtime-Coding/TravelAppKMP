package ui.component.article

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import model.Article
import theme.Black

@Composable
fun ArticleDescription(
    modifier: Modifier,
    article: Article
) {
    Column {
        Text(
            modifier = modifier,
            text = article.description,
            color = Black,
            style = MaterialTheme.typography.bodySmall,
            fontSize = TextUnit(10f, TextUnitType.Sp)
        )
    }
}