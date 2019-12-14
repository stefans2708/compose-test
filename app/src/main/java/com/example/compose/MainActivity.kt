package com.example.compose

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.unaryPlus
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Surface
import androidx.ui.text.ParagraphStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import com.example.compose.model.ViewData

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
fun Counter(state: ViewData, style: ButtonStyle = OutlinedButtonStyle()) {
    Button(text = "I've been clicked ${state.clickCount} times",
            style = style,
            onClick = {
                state.clickCount++
            })
}

@Composable
fun CheckBoxState(state: ViewData) {
    val context = +ambient(ContextAmbient)

    Checkbox(checked = state.checked,
            onCheckedChange = { newState ->
                state.checked = newState
                Toast.makeText(context, "Changed", Toast.LENGTH_SHORT).show()
            })
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Pera", "Mika", "Laza"),
                    viewData: ViewData = ViewData()) {
    Column(modifier = ExpandedHeight) {
        Column(modifier = Spacing(10.dp) wraps Flexible(1f)) {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.DarkGray, height = 4.dp)
            }
            Divider(color = Color.Transparent, height = 32.dp)
            Row {
                Column(modifier = Flexible(1f)) {
                    Counter(state = viewData)
                }
                CheckBoxState(state = viewData)
            }
        }
        Counter(state = viewData,
                style = ContainedButtonStyle(color = if (viewData.clickCount > 3) Color.Green else Color.White))
    }
}

@Preview
@Composable
fun DefaultPreview() {
    Container {
        MyScreenContent()
    }
}