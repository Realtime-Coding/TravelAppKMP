package model

import org.jetbrains.compose.resources.DrawableResource
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.fake_author

data class Article(
    val id: String,
    val title: String,
    val subTitle: String,
    val location: String,
    val thumbnail: String,
    val authorName: String,
    val authorImage: DrawableResource = Res.drawable.fake_author,
    val publishedDate: String,
    val type: String,
    val description: String,
    val readAlso: Article?,
    val paragraphs: List<Paragraph>,
    val moreArticles: List<Article>
    )

data class Paragraph(
    val title: String,
    val image: String,
    val description: String,
    val destination: Destination?
)
