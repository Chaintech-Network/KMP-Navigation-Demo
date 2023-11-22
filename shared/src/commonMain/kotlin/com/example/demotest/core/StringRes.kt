package com.example.demotest.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.intl.Locale

@Immutable
data class StringResources(
    val labelHomeScreen: String = "",
    val labelDetailScreen: String = "",
    val appBackground: String = "",
    val appBackgroundTemplate: String = ""
)

fun stringResourcesEn() = StringResources(
    labelHomeScreen = "Home Screen",
    labelDetailScreen = "Detail Screen",
    appBackground = "App background",
    appBackgroundTemplate = "App background %s dummy text at %s"
)

fun stringResourcesDe() = StringResources(
    labelHomeScreen = "Home Screen DE",
    labelDetailScreen = "Detail Screen DE",
    appBackground = "App hintergrund DE",
    appBackgroundTemplate = "Hintergrund der App %s Dummy-Text um %s DE"
)

val LocalStringResources = staticCompositionLocalOf { stringResourcesEn() }

@Composable
fun ApplicationTheme(content: @Composable () -> Unit) {
    val stringResources = when (Locale.current.language) {
        "DE" -> stringResourcesDe()
        else -> stringResourcesEn()
    }
    CompositionLocalProvider(LocalStringResources provides stringResources) {
        content()
    }
}

fun String.formatString(vararg args: Any): String {
    val regex = Regex("%s")
    var currentIndex = 0

    return regex.replace(this) {
        val replacement = args.getOrNull(currentIndex)?.toString() ?: ""
        currentIndex++
        replacement
    }
}