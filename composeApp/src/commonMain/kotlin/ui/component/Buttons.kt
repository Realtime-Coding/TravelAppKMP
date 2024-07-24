package ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import theme.White
import theme.PrimaryColor

@Composable
fun PrimaryButton(title: String, paddingValues: PaddingValues = PaddingValues(), onClick: () -> Unit){
    Box(
        Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .clickable { onClick.invoke() }
            .background(color = PrimaryColor, shape = RoundedCornerShape(size = 8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = title,
            color = White,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}