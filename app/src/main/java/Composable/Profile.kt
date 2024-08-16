import Composable.Onboarding
import Composable.TopAppBar
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    val firstName = sharedPref.getString("firstName", "N/A")
    val lastName = sharedPref.getString("lastName", "N/A")
    val email = sharedPref.getString("email", "N/A")

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // TopAppBar at the top
        TopAppBar()

        // User information
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Profile Information",
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = androidx.compose.ui.Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
            Text(
                text = "First Name: $firstName",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = androidx.compose.ui.Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Last Name: $lastName",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = androidx.compose.ui.Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Email: $email",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = androidx.compose.ui.Modifier.padding(top = 8.dp)
            )
        }

        // Log Out button at the bottom
        Button(
            onClick = {
                // Clear the stored user data
                with(sharedPref.edit()) {
                    clear()
                    apply()
                }
                // Navigate back to the Onboarding screen
                navController.navigate(Onboarding.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            },
            modifier = androidx.compose.ui.Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Log Out", color = Color.White, fontSize = 18.sp)
        }
    }
}
