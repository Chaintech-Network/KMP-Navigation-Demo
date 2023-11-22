package com.example.demotest.navigation

import cafe.adriel.voyager.core.screen.Screen
import com.example.demotest.ui.screen.DetailScreen
import com.example.demotest.ui.screen.WebViewScreen

class ScreenContainerProvider() : ScreenContainer {

    override fun goToDetail(): Screen = DetailScreen()
    override fun goToWebView(): Screen = WebViewScreen()

}
