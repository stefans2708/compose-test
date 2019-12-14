package com.example.compose.model

import androidx.compose.Model

@Model
class ViewData(var clickCount: Int = 0,
               var checked: Boolean = false)