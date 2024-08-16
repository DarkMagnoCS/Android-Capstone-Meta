package Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MenuItems(navController: NavHostController, dishRepository: DishRepository) {
    val dishes = dishRepository.dishes

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(dishes) { dish ->
            DishItem(dish, navController)
        }
    }
}

@Composable
fun DishItem(dish: Dish, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .padding(top = 5.dp, bottom = 5.dp)
                )
                Text(
                    text = "$${dish.price}",
                    style = MaterialTheme.typography.bodySmall
                )
                Image(
                    painter = painterResource(id = dish.imageResource),
                    contentDescription = dish.name,
                    modifier = Modifier
                        .size(30.dp)  // Keep image size small
                        .clip(RoundedCornerShape(10.dp))
                        .padding(start = 8.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

