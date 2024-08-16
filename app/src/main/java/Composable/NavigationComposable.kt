package Composable

import ProfileScreen
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

fun isUserLoggedIn(context: Context): Boolean {
    val sharedPref = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    val firstName = sharedPref.getString("firstName", null)
    val lastName = sharedPref.getString("lastName", null)
    val email = sharedPref.getString("email", null)

    return !firstName.isNullOrEmpty() && !lastName.isNullOrEmpty() && !email.isNullOrEmpty()
}

@Composable
fun MyNavigation(navController: NavHostController) {
    val context = LocalContext.current

    // Check if the user is logged in
    val startDestination = if (isUserLoggedIn(context)) {
        Home.route
    } else {
        Onboarding.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(Home.route) {
            HomeScreen(navController)
        }
        composable(Profile.route) {
            ProfileScreen(navController)
        }
    }
}
