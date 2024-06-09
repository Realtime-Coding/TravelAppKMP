package ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Category
import org.jetbrains.compose.resources.painterResource
import theme.CategoryBgColor
import theme.SecondTextColor

@Composable
fun categoryItem(category: Category, onItemClicked: (Category) -> Unit) {
    Box(
        modifier = Modifier
            .clickable { onItemClicked.invoke(category) }
            .background(
                color = CategoryBgColor,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 9.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.width(17.dp).height(20.dp),
                painter = painterResource(category.image),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = category.title,
                color = SecondTextColor,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun loadCategoryItems(categories: List<Category>, onItemClicked: (Category) -> Unit){
    LazyRow(
        modifier = Modifier.padding(start = 16.dp, top = 22.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = categories,
            itemContent = { categoryItem(it , onItemClicked) }
        )
    }
}