package ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import model.Destination
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import theme.TextColor
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.cart_tab
import travelbuddy.composeapp.generated.resources.menu_cart
import ui.component.CartCard
import ui.component.LoadItemAfterSafeCast
import ui.viewmodel.HomeViewModel
import util.BOTTOM_NAV_SPACE

data object CartTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.cart_tab)
            val icon = painterResource(Res.drawable.menu_cart)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        CartScreenView(navigator)
    }
}

@Composable
fun CartScreenView(
    navigator: Navigator,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel { HomeViewModel() },
) {
    val cartItems by viewModel.cartItems.collectAsState()

    Surface(modifier = Modifier.fillMaxWidth().padding(bottom = BOTTOM_NAV_SPACE)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            item {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 36.dp),
                    text = "Cart",
                    color = TextColor,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
            item {
                Spacer(
                    modifier = Modifier.padding(top = 16.dp),
                )
            }
            item {
                cartItems.forEach { item ->
                    LoadItemAfterSafeCast<Destination>(item) {
                        CartCard(
                            destination = item,
                            onDelete = {
                                viewModel.removeFromCart(it)
                            },
                            onClickBook = {

                            }
                        )
                    }
                }
            }
        }
    }
}