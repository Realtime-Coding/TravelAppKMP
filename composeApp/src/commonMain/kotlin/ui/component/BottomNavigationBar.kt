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
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import util.AnimateVisibility
import org.jetbrains.compose.resources.painterResource
import theme.White
import theme.primaryColor
import theme.secondTextColor
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.star
import ui.screen.CartScreen
import ui.screen.FavoriteScreen
import ui.screen.HomeScreen
import ui.screen.ProfileScreen


val menuItems = arrayListOf<Tab>().apply {
    add(HomeScreen)
    add(FavoriteScreen)
    add(CartScreen)
    add(ProfileScreen)
}

enum class Menu(index: Int) {
    HOME(0),
    FAVORITE(1),
    CART(2),
    PROFILE(3),
}

@Composable
private fun BottomMenuItem(
    tab: Tab,
    tabNavigator: TabNavigator,
    onItemClicked: @Composable (Tab) -> Unit
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
            painter = tab.options.icon ?: painterResource(Res.drawable.star),
            contentDescription = tab.options.title,
            tint = if (tabNavigator.current == tab) primaryColor else secondTextColor
        )
        AnimateVisibility(
            visible = tabNavigator.current == tab,
            modifier = Modifier
                .wrapContentSize(Alignment.BottomStart)
        ) {
            Divider(
                modifier = Modifier
                    .width(22.dp)
                    .padding(top = 4.dp)
                    .background(color = primaryColor, shape = RoundedCornerShape(16.dp)),
                thickness = 4.dp,
                color = primaryColor
            )
        }
    }
}

@Composable
fun BottomMenuBar(
    modifier: Modifier = Modifier,
    tabs: List<Tab>,
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
            modifier = Modifier.fillMaxWidth().padding(vertical = 18.dp, horizontal = 40.dp),
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
private fun LazyItemScope.TabNavigationItem(tab: Tab, onItemClicked: @Composable (Tab) -> Unit) {
    val tabNavigator = LocalTabNavigator.current
    BottomMenuItem(tab,tabNavigator) {
        onItemClicked.invoke(it)
    }
}

