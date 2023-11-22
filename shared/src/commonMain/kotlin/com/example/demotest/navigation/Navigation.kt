package com.example.demotest.navigation

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.compositionLocalOf

interface Navigation {
    fun back(): Boolean

    fun goToDetail(): Boolean
    fun goToWebView(): Boolean
}

val LocalNavigation = compositionLocalOf<Navigation> { error("navigation failure") }