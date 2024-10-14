package com.example.geoquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.geoquiz.ui.theme.GeoQuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GeoQuizTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Dylan",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Remember the text to display as a mutable state
    val textToDisplay = remember { mutableStateOf("Hello World!") }

    // Use Box to center items
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize() // Makes the Box fill the entire screen
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly, // Evenly space out the items
            horizontalAlignment = Alignment.CenterHorizontally // Center items horizontally
        ) {
            Text(text = "Hello $name!")
            Text(text = textToDisplay.value)
            // Button to change text when clicked
            Button(onClick = {
                textToDisplay.value = "Button Clicked!"
            }) {
                Text("Click me!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GeoQuizTheme {
        Greeting(name = "Dylan")
    }
}
