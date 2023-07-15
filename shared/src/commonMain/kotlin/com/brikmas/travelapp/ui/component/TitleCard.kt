package com.brikmas.travelapp.ui.component

import androidx.compose.foundation.layout.Arrangement
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
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource


@Composable
fun TitleWithViewAllItem(title: String, label: String, icon: ImageResource) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 36.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            color = colorResource(SharedRes.colors.textColor),
            style = MaterialTheme.typography.titleLarge
        )
        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                color = colorResource(SharedRes.colors.thirdTextColor),
                style = MaterialTheme.typography.labelSmall
            )
            Icon(
                modifier = Modifier.size(24.dp).padding(start = 8.dp),
                painter = painterResource(icon),
                contentDescription = null,
                tint = colorResource(SharedRes.colors.primaryColor)
            )
        }
    }
}
