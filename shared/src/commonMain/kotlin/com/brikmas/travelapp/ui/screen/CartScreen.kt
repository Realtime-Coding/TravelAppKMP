package com.brikmas.travelapp.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.brikmas.travelapp.Navigation.Route
import com.brikmas.travelapp.SharedRes
import dev.icerock.moko.resources.compose.colorResource

@Composable
fun CartScreen(routeState: MutableState<Route>){
    Surface(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.wrapContentSize(Alignment.Center),
            text = "Cart",
            color = colorResource(SharedRes.colors.textColor),
            style = MaterialTheme.typography.titleLarge,
        )
    }
}