package ui.component.article

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import model.Paragraph
import theme.Black
import util.ImageItem

@Composable
fun ArticlePharagraphs(modifier: Modifier, pharagraph: Paragraph) {
    Column(
        modifier = Modifier.padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            modifier = modifier,
            text = pharagraph.title,
            color = Black,
            style = MaterialTheme.typography.bodyMedium
        )
        ImageItem(
            data = pharagraph.image,
            modifier = Modifier
                .height(height = 220.dp)
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
                },
            shape = RoundedCornerShape(0.dp)
        )
        Text(
            modifier = modifier,
            text = pharagraph.description,
            color = Black,
            style = MaterialTheme.typography.bodySmall,
            fontSize = TextUnit(10f, TextUnitType.Sp)
        )
        Spacer(modifier = Modifier.padding(top = 4.dp))
        pharagraph.destination?.let {
            ArticleDestination(modifier, it,{},{})
        }
        Spacer(modifier = Modifier.padding(top = 8.dp))
    }
}