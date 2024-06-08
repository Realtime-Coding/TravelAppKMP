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
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import theme.textColor

data object CartScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        CartScreenView()
    }
}

@Composable
fun CartScreenView(){
    Surface(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.wrapContentSize(Alignment.Center),
            text = "Cart",
            color = textColor,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}