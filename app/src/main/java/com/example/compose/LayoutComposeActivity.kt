package com.example.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text

import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.SolidColor
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class LayoutComposeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            newsStory()
        }
    }
}

@Composable
fun newsStory() {
    val image = +imageResource(R.drawable.ic_header)

    MaterialTheme {
        val typography = +MaterialTheme.typography()

        Column(modifier = Spacing(16.dp))
        {
            Container(modifier = Height(180.dp) wraps Expanded) {
                Clip(shape = RoundedCornerShape(8.dp)) {
                    DrawImage(image = image)
                }
            }

            HeightSpacer(16.dp)

            Text("Weather for today", style = typography.h5)
            Surface(color = Color.Cyan,
                    shape = RoundedCornerShape(10.dp),
                    border = Border(SolidColor(Color.Magenta), 4.dp)) {
                Text("This text must be 2 lines only. This text must be 2 lines only. This text must be 2 lines only. This text must be 2 lines only. This text must be 2 lines only. This text must be 2 lines only.",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Spacing(8.dp),
                        style = typography.body1.withOpacity(0.64f))
            }
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    style = typography.body2)

        }
    }
}

@Preview
@Composable
fun defaultPreview() {
    newsStory()
}