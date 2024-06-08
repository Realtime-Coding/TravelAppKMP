package ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import theme.primaryColor
import theme.reviewBodyBg
import theme.secondTextColor
import theme.textColor
import theme.thirdTextColor
import theme.yellow


@Composable
fun TitleWithViewAllItem(title: String, label: String, icon: DrawableResource) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 36.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            color = textColor,
            style = MaterialTheme.typography.bodySmall
        )
        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                color = thirdTextColor,
                style = MaterialTheme.typography.bodySmall
            )
            Icon(
                modifier = Modifier.size(24.dp).padding(start = 8.dp),
                painter = painterResource(icon),
                contentDescription = null,
                tint = primaryColor
            )
        }
    }
}

@Composable
fun TitleWithReview(title: String, label: String, icon: DrawableResource) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 36.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            color = textColor,
            style = MaterialTheme.typography.bodySmall
        )
        Box(
            modifier = Modifier
                .background(color = reviewBodyBg, shape = RoundedCornerShape(4.dp))
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = yellow
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = label,
                    color = secondTextColor,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
