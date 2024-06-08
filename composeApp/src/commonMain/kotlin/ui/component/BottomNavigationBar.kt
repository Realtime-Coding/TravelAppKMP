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
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import Navigation.Route
import Navigation.Screen
import model.MenuItem
import util.AnimateVisibility
import org.jetbrains.compose.resources.painterResource
import theme.White
import theme.primaryColor
import theme.secondTextColor
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.menu_cart
import travelbuddy.composeapp.generated.resources.menu_fav
import travelbuddy.composeapp.generated.resources.menu_home
import travelbuddy.composeapp.generated.resources.menu_profile


val menuItems = arrayListOf<MenuItem>().apply {
    add(MenuItem(Menu.HOME, "Home", Res.drawable.menu_home, Screen.Home))
    add(MenuItem(Menu.FAVORITE, "Favorite", Res.drawable.menu_fav, Screen.Favorite))
    add(MenuItem(Menu.CART, "Cart", Res.drawable.menu_cart, Screen.Cart))
    add(MenuItem(Menu.PROFILE, "Profile", Res.drawable.menu_profile, Screen.Profile))
}

enum class Menu(index: Int) {
    HOME(0),
    FAVORITE(1),
    CART(2),
    PROFILE(3),
}

@Composable
private fun BottomMenuItem(
    menuItem: MenuItem,
    route: MutableState<Route>,
    onItemClicked: (MenuItem) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(34.dp).clickable { onItemClicked.invoke(menuItem) },
            painter = painterResource(menuItem.icon),
            contentDescription = menuItem.title,
            tint = if (route.value.screen == menuItem.screen) primaryColor else secondTextColor
        )
        AnimateVisibility(
            visible = route.value.screen == menuItem.screen,
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
    route: MutableState<Route>,
    menuItems: List<MenuItem>,
    onItemClicked: (MenuItem) -> Unit,
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
                items = menuItems,
                itemContent = { item ->
                    BottomMenuItem(item,route) {
                        onItemClicked.invoke(it)
                    }
                }
            )
        }
    }
}