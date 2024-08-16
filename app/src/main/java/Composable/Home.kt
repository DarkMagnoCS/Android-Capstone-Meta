package Composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.learning.littlelemon.ui.theme.DefaultButtonColor
import com.learning.littlelemon.ui.theme.GreenMain
import com.learning.littlelemon.ui.theme.HighlightDark
import com.learning.littlelemon.ui.theme.HighlightLight
import com.learning.littlelemon.ui.theme.LightButtonColor
import com.learning.littlelemon.ui.theme.LittleLemonTheme
import com.learning.littlelemon.ui.theme.YellowMain


@Composable
fun HomeScreen() {
    LittleLemonTheme {
        Column() {
            TopAppBar()
            HeroBanner()
        }
    }
}

@Composable
fun HeroBanner() {
    var searchPhrase by remember { mutableStateOf("") }

    LittleLemonTheme {
        val focusManager = LocalFocusManager.current

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = GreenMain)
        ) {
            Text(
                text = "Little Lemon",
                color = YellowMain,
                modifier = Modifier.padding(10.dp),
            )
            Text(
                text = "Chicago",
                color = HighlightLight,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
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
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp)),
                value = searchPhrase,
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Reserve a table",
                        color = HighlightDark,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    searchPhrase = it
                    },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon"
                    )
                },
            )
        }
    }
}


@Composable
fun CategoryButton(category: String, action: () -> Unit) {
    TextButton(
        modifier = Modifier
            .height(40.dp)
            .padding(end = 20.dp),
        colors = LightButtonColor,
        shape = RoundedCornerShape(15.dp),
        onClick = {
            action()
        }
    ) {
        Text(
            text = category,
            color = HighlightDark,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    }