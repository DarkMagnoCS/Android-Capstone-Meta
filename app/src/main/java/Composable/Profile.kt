import Composable.Onboarding
import Composable.TopAppBar
import android.content.Context
import androidx.compose.foundation.background
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
import com.learning.littlelemon.ui.theme.GreenMain
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
            .fillMaxHeight()
            .background(color = GreenMain),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar()
            Text(
                text = "Profile Screen",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = androidx.compose.ui.Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
            Text(
                text = "First Name: $firstName",
                fontSize = 20.sp,
                color = Color.White,
                modifier = androidx.compose.ui.Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Last Name: $lastName",
                fontSize = 20.sp,
                color = Color.White,
                modifier = androidx.compose.ui.Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Email: $email",
                fontSize = 20.sp,
                color = Color.White,
                modifier = androidx.compose.ui.Modifier.padding(top = 8.dp)
            )
        }

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
