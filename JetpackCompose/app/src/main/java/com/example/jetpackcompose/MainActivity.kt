package com.example.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ViewContainer()
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        content =  {
            Content()
        },
        floatingActionButton = { Fab() },
        floatingActionButtonPosition = FabPosition.End
    )
}

@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Text(
                text = "jocode Profile",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        backgroundColor = Color.White,
        elevation = 5.dp
    )
}

@Composable
fun Fab() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Hello world!", Toast.LENGTH_SHORT).show()
    }) {
        Image(
            painter = painterResource(id = R.drawable.ic_favorite),
            contentDescription = "Favorite"
        )
    }
}

@Composable
fun Content() {
    var counter by rememberSaveable { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(16.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Logo de la company",
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            counter++
                        }
                )
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Text(
                text = "jocode",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            LazyRow(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                item {
                    Tag("Android")
                    Tag("Java")
                    Tag("Kotlin")
                    Tag("Javascript")
                    Tag("Python")
                    Tag("PHP")
                    Tag("Go")
                    Tag("C++")
                    Tag("HTML")
                    Tag("CSS")
                }
            }
        }
    }
}

@Preview
@Composable
fun Tag(text: String = "Hola mundo") {
    Text(
        text = text,
        color = Color.White,
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.Gray)
            .padding(horizontal = 10.dp, vertical = 5.dp)
    )
}

//@Preview(showBackground = true)
@Composable
fun helloApp() {
    JetpackComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Greeting("Android")
        }
    }
}

@Composable
fun exampleModifier() {
    Text(
        text = "Esto mola bien",
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Greeting("Android seems well")
    }
}