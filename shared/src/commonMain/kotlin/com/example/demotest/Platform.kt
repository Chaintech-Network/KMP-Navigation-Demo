package com.example.demotest

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.demotest.core.ViewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

@Composable
expect fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font

