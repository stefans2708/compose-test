package com.example.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.material.ColorPalette
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.text.font.FontFamily
import androidx.ui.tooling.preview.Preview

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greetings("Danny")
        }
    }

}

@Composable
fun Greetings(text: String) {
    Text(text = text,
            modifier = Spacing(24.dp))
}

val green = Color(0xFF1EB980)
private val myAppThemeColors = ColorPalette(
        primary = Color.Blue,
        surface = Color.DarkGray,
        onSurface = green
)

@Composable
fun MyAppTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = myAppThemeColors) {
        children()
    }
}

@Preview
@Composable
fun Preview() {
    MyAppTheme {
        Column {
            Surface {
                Greetings("Danny")
            }
            Text(text = "Testing styles",
                    modifier = Spacing(24.dp),
                    style = (+MaterialTheme.typography()).body1.copy(color = Color.Red))
            Text(text = "Testing styles 2",
                    modifier = Spacing(24.dp),
                    style = (+MaterialTheme.typography()).h5.copy(
                            color = (+MaterialTheme.colors()).primary,
                            background = Color.LightGray,
                            fontFamily = FontFamily.Monospace))
        }
    }
}
