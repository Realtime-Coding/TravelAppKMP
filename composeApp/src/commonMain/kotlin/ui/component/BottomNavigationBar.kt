package ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import util.AnimateVisibility
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import theme.White
import theme.PrimaryColor
import theme.SecondTextColor
import ui.screen.CartTab
import ui.screen.FavoriteTab
import ui.screen.HomeTab
import ui.screen.GeminiTab

interface Tabx: Tab {
    fun defaultTitle(): StringResource
    fun defaultIcon(): DrawableResource
}

val tabs = arrayListOf<Tabx>().apply {
    add(HomeTab)
    add(FavoriteTab)
    add(CartTab)
    add(GeminiTab)
}

@Composable
private fun BottomMenuItem(
    tab: Tabx,
    tabNavigator: TabNavigator,
    onItemClicked: @Composable (Tabx) -> Unit
) {
    var visible by remember { mutableStateOf(false) }
    if (visible) {
        onItemClicked.invoke(tab)
        visible = false
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(34.dp).clickable { visible = true },
            painter = painterResource(tab.defaultIcon()),
            contentDescription = stringResource(tab.defaultTitle()),
            tint = if (tabNavigator.current == tab) PrimaryColor else SecondTextColor
        )
        Text(
            modifier = Modifier,
            text = stringResource(tab.defaultTitle()),
            color = if (tabNavigator.current == tab) PrimaryColor else SecondTextColor,
            style = MaterialTheme.typography.bodySmall
        )
        AnimateVisibility(
            visible = tabNavigator.current == tab,
            modifier = Modifier
                .wrapContentSize(Alignment.BottomStart)
        ) {
            HorizontalDivider(
                modifier = Modifier
                    .width(40.dp)
                    .padding(top = 4.dp)
                    .background(color = PrimaryColor, shape = RoundedCornerShape(22.dp)),
                thickness = 4.dp,
                color = PrimaryColor
            )
        }
    }
}

@Composable
fun BottomMenuBar(
    modifier: Modifier = Modifier,
    tabs: List<Tabx>,
    onItemClicked: @Composable (Tab) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = White,
                shape = RoundedCornerShape(size = 0.dp)
            ),
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items(
                items = tabs,
                itemContent = { item ->
                    TabNavigationItem(item,onItemClicked)
                }
            )
        }
    }
}

@Composable
private fun TabNavigationItem(tab: Tabx, onItemClicked: @Composable (Tabx) -> Unit) {
    val tabNavigator = LocalTabNavigator.current
    BottomMenuItem(tab,tabNavigator) {
        onItemClicked.invoke(it)
    }
}

