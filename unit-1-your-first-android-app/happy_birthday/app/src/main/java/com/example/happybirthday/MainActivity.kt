package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthDayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingsImage(message = "Happy B'day Heshan", from = "Heshan")
                }
            }
        }
    }
}

@Composable
fun GreetingTest(message: String,  from: String, modifier: Modifier = Modifier) {
    Column( verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(24.dp)
    ) {

        Text(text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center)
        Text(text = from,
            fontSize = 36.sp,
            modifier = Modifier

                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally))
    }
}

@Composable
fun GreetingsImage(message: String,  from: String, modifier: Modifier = Modifier) {
    painterResource(id = R.drawable.androidparty).also {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = it,
                alpha = 0.5F,
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(id = R.string.image_description)
            )
            GreetingTest(message = message, from = "From $from")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthDayTheme {
        GreetingsImage(message = stringResource(id = R.string.message),
            from = stringResource(id = R.string.signature))
    }
}