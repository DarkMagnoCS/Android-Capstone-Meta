package Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.learning.littlelemon.ui.theme.GreenMain
import com.learning.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun Onboarding(innerPadding: PaddingValues, navHostController: NavHostController) {
    LittleLemonTheme {
        Column(modifier = Modifier.padding(innerPadding)) {
            //OnboardingForm(navHostController)
        }
    }
}

@Composable
fun OnboardingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header with logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(top = 32.dp, bottom = 16.dp)
                .size(150.dp) // Increase size
        )

        // Centered Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = GreenMain)
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Let's get to know you",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Personal Information Title
        Text(
            text = "Personal information",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.Start)
        )

        // First Name Input
        var firstName by remember { mutableStateOf("") }
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Last Name Input
        var lastName by remember { mutableStateOf("") }
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Email Input
        var email by remember { mutableStateOf("") }
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )

        // Register Button
        Button(
            onClick = { /* Handle registration logic */ },
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text("Register",
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen()
}