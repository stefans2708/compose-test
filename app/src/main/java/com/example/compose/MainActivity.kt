package com.example.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.OutlinedButtonStyle
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview
import com.example.compose.model.CounterState

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Container {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Spacing(24.dp))
}

@Composable
fun Container(children: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.Yellow) {
            children()
        }
    }
}

@Composable
fun Counter(state: CounterState) {
    Button(text = "I've been clicked ${state.count} times",
            style = OutlinedButtonStyle(),
            onClick = {
                state.count++
            })
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Pera", "Mika", "Laza"),
                    counterState: CounterState = CounterState()) {
    Column(modifier = Spacing(10.dp)) {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.DarkGray, height = 4.dp)
        }
        Divider(color = Color.Transparent, height = 32.dp)
        Counter(state = counterState)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    Container {
        MyScreenContent()
    }
}