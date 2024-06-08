package ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import theme.textColor

data object ProfileScreen : cafe.adriel.voyager.core.screen.Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        ProfileScreenView(navigator)
    }
}

@Composable
fun ProfileScreenView(navigator: Navigator){
    Surface(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.wrapContentSize(Alignment.Center),
            text = "Profile",
            color = textColor,
            style = MaterialTheme.typography.bodySmall
        )
    }
}