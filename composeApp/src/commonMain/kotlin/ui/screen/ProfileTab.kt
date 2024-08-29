package ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import theme.TextColor
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.menu_profile
import travelbuddy.composeapp.generated.resources.profile_tab
import util.BOTTOM_NAV_SPACE

data object ProfileTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.profile_tab)
            val icon = painterResource(Res.drawable.menu_profile)

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
        ProfileScreenView(navigator)
    }
}

@Composable
fun ProfileScreenView(navigator: Navigator){
    Surface(modifier = Modifier.fillMaxWidth().padding(bottom = BOTTOM_NAV_SPACE)) {
        Text(
            modifier = Modifier.wrapContentSize(Alignment.Center),
            text = stringResource(Res.string.profile_tab),
            color = TextColor,
            style = MaterialTheme.typography.bodySmall
        )
    }
}