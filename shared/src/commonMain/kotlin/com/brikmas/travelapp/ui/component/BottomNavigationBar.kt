package com.brikmas.travelapp.ui.component

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brikmas.travelapp.SharedRes
import com.brikmas.travelapp.model.MenuItem
import com.brikmas.travelapp.util.AnimateVisibility
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource


val menuItems = arrayListOf<MenuItem>().apply {
    add(MenuItem(Menu.HOME, "Home", SharedRes.images.menu_home))
    add(MenuItem(Menu.FAVORITE, "Favorite", SharedRes.images.menu_fav))
    add(MenuItem(Menu.CART, "Cart", SharedRes.images.menu_cart))
    add(MenuItem(Menu.PROFILE, "Profile", SharedRes.images.menu_profile))
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
    rememberMenuItem: MutableState<MenuItem>,
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
            tint = colorResource(if (rememberMenuItem.value == menuItem) SharedRes.colors.primaryColor else SharedRes.colors.secondTextColor)
        )
        AnimateVisibility(
            visible = rememberMenuItem.value == menuItem,
            modifier = Modifier
                .wrapContentSize(Alignment.BottomStart)
        ) {
            Divider(
                modifier = Modifier
                    .width(22.dp)
                    .padding(top = 4.dp)
                    .background(color = colorResource(SharedRes.colors.primaryColor), shape = RoundedCornerShape(16.dp)),
                thickness = 4.dp,
                color = colorResource(SharedRes.colors.primaryColor)
            )
        }
    }
}

@Composable
fun BottomMenuBar(
    modifier: Modifier = Modifier,
    menuItems: List<MenuItem>,
    onItemClicked: (MenuItem) -> Unit,
) {
    val selectedMenuItem = remember { mutableStateOf(menuItems.first()) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = colorResource(SharedRes.colors.white),
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
                    BottomMenuItem(item,selectedMenuItem) {
                        onItemClicked.invoke(it)
                        selectedMenuItem.value = it
                    }
                }
            )
        }
    }
}