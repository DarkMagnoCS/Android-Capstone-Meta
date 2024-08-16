package Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.GreenMain
import com.example.littlelemon.ui.theme.HighlightLight
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.YellowMain

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
            modifier = Modifier.padding(top = 16.dp, bottom = 32.dp)
        )
        Box (
            modifier = Modifier

                .height(100.dp)
                .background(color = GreenMain)
        )
        {
            Text(
                text = "Let's get to know you",
                color = HighlightLight,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
                    .align(Alignment.Center)
            )
        }


        // First Name Input
        var firstName by remember { mutableStateOf("") }
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First name") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Last Name Input
        var lastName by remember { mutableStateOf("") }
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last name") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Email Input
        var email by remember { mutableStateOf("") }
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp)
        )

        // Register Button
        Button(
            onClick = { /* Handle registration logic */ },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Register")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen()
}
