package Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.learning.littlelemon.ui.theme.*

@Composable
fun HomeScreen(navController: NavHostController) {
    LittleLemonTheme {
        Column {
            TopAppBar()
            HeroBanner(navController = navController)
            MenuItems()
        }
    }
}

@Composable
fun HeroBanner(navController: NavHostController) {
    LittleLemonTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = GreenMain)
        ) {
            // Header Row with Text and Profile Image
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Little Lemon",
                        color = YellowMain,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Chicago",
                        color = HighlightLight,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Profile Image Button
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(25.dp))
                        .background(Color.LightGray)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("profile")
                        }
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.home_description),
                    color = HighlightLight,
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f)
                )
                Image(
                    painter = painterResource(id = R.drawable.hero),
                    contentDescription = "Hero",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }

            // Reserve a table Button
            Button(
                onClick = { navController.navigate("profile") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = HighlightDark
                )
            ) {
                Text(
                    text = "Reserve a table",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
}