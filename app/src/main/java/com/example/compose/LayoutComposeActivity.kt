package com.example.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Draw
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.res.imageResource
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
    DrawImage(image = image)

    Column(modifier = Spacing(16.dp))
    {
        Text("Weather for today")
        Text("Car racing tomorrow")
        Text("Politics")
    }
}

@Preview
@Composable
fun defaultPreview() {
    newsStory()
}