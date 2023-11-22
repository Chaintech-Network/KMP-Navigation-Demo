package com.example.demotest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey

interface ScreenContainer {

    fun goToDetail(): Screen
    fun goToWebView(): Screen

}

val LocalScreenContainer =
    compositionLocalOf<ScreenContainer> { error("screen container not found") }

