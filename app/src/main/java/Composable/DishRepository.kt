package Composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.littlelemon.R

object DishRepository {
    val dishes = listOf(

        Dish(
            2,
            "Lemon Desert",
            "Traditional homemade Italian Lemon Ricotta Cake.",
            8.99,
            R.drawable.lemondessert
        ),
        Dish(
            3,
            "Bruschetta",
            "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
            4.99,
            R.drawable.bruschetta
        ),
        Dish(
            4,
            "Grilled Fish",
            "Fish marinated in fresh orange and lemon juice. Grilled with orange and lemon wedges.",
            19.99,
            R.drawable.grilledfish
        ),
        Dish(
            5,
            "Pasta",
            "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chili, garlic, basil & salted ricotta cheese.",
            8.99,
            R.drawable.pasta
        ),
        Dish(
            6,
            "Lasagne",
            "Oven-baked layers of pasta stuffed with Bolognese sauce, béchamel sauce, ham, Parmesan & mozzarella cheese.",
            7.99,
            R.drawable.lasagne
        )
    )

    fun getDish(id: Int): Dish? = dishes.firstOrNull { it.id == id }
}

data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    @DrawableRes val imageResource: Int
)

@Composable
fun MenuItems() {
    val dishes = DishRepository.dishes
    Column {
        dishes.forEach { dish ->
            DishItem(dish)
        }
    }
}

@Composable
fun DishItem(dish: Dish) {
    Column {
        Text(text = dish.name)
        Text(text = dish.description)
        Text(text = "$${dish.price}")
        Image(
            painter = painterResource(id = dish.imageResource),
            contentDescription = dish.name
        )
    }
}
