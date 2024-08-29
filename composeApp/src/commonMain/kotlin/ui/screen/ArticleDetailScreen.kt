package ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import model.Article
import model.Destination
import theme.Black
import theme.BorderColor
import theme.White
import ui.component.ChildLayout
import ui.component.VerticalScrollLayout
import ui.component.article.ArticleBodyHeader
import ui.component.article.ArticleDescription
import ui.component.article.ArticleDestination
import ui.component.article.ArticleHeader
import ui.component.article.ArticleOther
import ui.component.article.ArticlePharagraphs
import ui.viewmodel.HomeViewModel
import util.BOTTOM_NAV_SPACE

data class ArticleDetailScreen(val article: Article) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        ArticleDetailScreenView(navigator, article)
    }
}

@Composable
fun ArticleDetailScreenView(
    navigator: Navigator,
    article: Article,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel { HomeViewModel() },
) {
    val rememberThumbnail = remember { mutableStateOf(article.thumbnail) }
    Column(
        modifier = Modifier
            .padding(bottom = BOTTOM_NAV_SPACE)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        ArticleHeader(
            navigator,
            article,
            rememberThumbnail,
            checkFavorite = {
                //viewModel.checkFavorite(it)
                false
            },
            addFavorite = {
                //viewModel.addFavorite(it)
            },
            removeFavorite = {
                //viewModel.removeFavorite(it)
            },
            updateBottomNavBarVisible = {
                //viewModel.setBottomNavBarVisible(true)
            }
        )
        contentSection(article) {

        }
    }
}

@Composable
private fun contentSection(article: Article, onImageClicked: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = -40.dp)
            .background(
                color = White,
                shape = RoundedCornerShape(26.dp, 26.dp, 0.dp, 0.dp)
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 28.dp),
        ) {
            val horizontalSpace = 16.dp
            ArticleBodyHeader(
                modifier = Modifier.padding(horizontal = horizontalSpace),
                article = article,
                onFavourite = {},
                onShare = {}
            )
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            ArticleDescription(
                modifier = Modifier.padding(horizontal = horizontalSpace),
                article = article
            )
            article.paragraphs.forEach {
                ArticlePharagraphs(
                    modifier = Modifier.padding(horizontal = horizontalSpace),
                    pharagraph = it
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            article.moreArticles.takeIf { it.isNotEmpty() }?.let { articles ->
                Text(
                    modifier = Modifier.padding(horizontal = horizontalSpace),
                    text = "More Articles",
                    color = Black,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                articles.forEach { article ->
                    ArticleOther(
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = horizontalSpace),
                        article = article
                    ) { }
                }
            }
        }
    }
}
