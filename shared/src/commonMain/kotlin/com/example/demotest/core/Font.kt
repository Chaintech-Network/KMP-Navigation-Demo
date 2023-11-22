package com.example.demotest.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.demotest.font

object Fonts {
    @Composable
    fun poppinsRegular() = FontFamily(
        font(
            "poppins_medium",
            "poppins_medium",
            FontWeight.Bold,
            FontStyle.Normal
        ),
    )
}

