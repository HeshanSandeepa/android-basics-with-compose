package com.example.business_card

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business_card.ui.theme.BusinesscardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinesscardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
//                    ComposeArticle(R.drawable.bg_compose_background,
//                        stringResource(id = R.string.first),
//                        stringResource(
//                        id = R.string.second
//                    ))
                }
            }
        }
    }
}



@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box {

        }
        Box {
            Column(verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.ic_task_completed),
                    contentDescription = stringResource(id = R.string.dog_content_description)
                )
                Text(
                    text = "Jennifer Doe",
                    fontSize = 32.sp,
                    modifier = modifier.padding(16.dp)
                )
                Text(
                    text = "Android Developer",
                    textAlign = TextAlign.Justify,
                    modifier = modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
        }
        Box {

        }
        Box {
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start) {

                Row(horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.Call, contentDescription = "")
                    Text(
                        text = "+11 (123) 444 555 666",
                        fontSize = 12.sp,
                        modifier = modifier.padding(16.dp)
                    )
                }
                Row(horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "")
                    Text(
                        text = "@AndroidDev",
                        fontSize = 12.sp,
                        modifier = modifier.padding(16.dp)
                    )
                }
                Row(horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically ) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "")
                    Text(
                        text = "hreshan@gamil.com",
                        fontSize = 12.sp,
                        modifier = modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}



@Composable
fun ComposeArticle(image: Int,
                   firstText: String,
                   secondText: String,
                   modifier: Modifier = Modifier) {
    Column {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(id = R.string.dog_content_description)
        )
        Text(
            text = "Jetpack Compose Tutorial",
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = firstText,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = secondText,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
    }
}


@Composable
fun TaskManager(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = stringResource(id = R.string.dog_content_description)
        )
        Text(
            text = "All tasks completed",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Nice work",
            fontSize = 16.sp,
        )
    }
}

@Composable
fun Quadrant(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Box(modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp) // adding some space to the label
                .background(
                    Color(0xFFEADDFF),
                    shape = RoundedCornerShape(4.dp)
                )) {
                Column {
                    Text(
                        text = "Text composable",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines.",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }
            }
            Box(modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp) // adding some space to the label
                .background(
                    Color(0xFFEADDFF),
                    shape = RoundedCornerShape(4.dp)
                )) {
                Column {
                    Text(
                        text = "Text composable",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines.",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }
            }

        }
        Row {
            Box(modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp) // adding some space to the label
                .background(
                    Color(0xFFEADDFF),
                    shape = RoundedCornerShape(4.dp)
                )) {
                Column {
                    Text(
                        text = "Text composable",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines.",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }
            }
            Box(modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp) // adding some space to the label
                .background(
                    Color(0xFFEADDFF),
                    shape = RoundedCornerShape(4.dp)
                )) {
                Column {
                    Text(
                        text = "Text composable",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines.",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinesscardTheme {
        BusinessCard()

    }
}