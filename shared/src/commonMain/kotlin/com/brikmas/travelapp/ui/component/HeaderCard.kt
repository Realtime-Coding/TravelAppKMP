package com.brikmas.travelapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brikmas.travelapp.SharedRes
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.fontFamilyResource
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun homeHeader(){
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(SharedRes.images.humberg_icon),
            contentDescription = null
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Current Location",
                color = colorResource(SharedRes.colors.secondTextColor),
                fontFamily = fontFamilyResource(SharedRes.fonts.sf_pro_regular.sf_pro_regular),
                style = MaterialTheme.typography.titleSmall
            )
            Row(
                modifier = Modifier.padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(SharedRes.images.ci_location),
                    contentDescription = null,
                    tint = colorResource(SharedRes.colors.primaryColor)
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Denpasar, Bali",
                    color = colorResource(SharedRes.colors.textColor),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(SharedRes.images.profile_icon),
            contentDescription = null
        )
    }
}

@Composable
fun destinationDetailHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(SharedRes.images.back),
            contentDescription = null
        )
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(SharedRes.images.favorite),
            contentDescription = null
        )
    }
}