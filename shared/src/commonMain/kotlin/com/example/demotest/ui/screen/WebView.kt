package com.example.demotest.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.demotest.core.Fonts
import com.example.demotest.core.FromLocalDrawable
import com.example.webview.WebView
import com.example.webview.rememberWebViewState

class WebViewScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF9F7EA))) {
            Card(
                Modifier.fillMaxWidth(),
                elevation = 1.dp,
                shape = RectangleShape,
                backgroundColor = Color.Transparent,
                contentColor = Color.Transparent
            ) {
                Row(
                    Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    FromLocalDrawable(
                        painterResource = "ic_back_arrow.png",
                        modifier = Modifier.padding(vertical = 12.dp).size(26.dp).clickable {
                            navigator.pop()
                        },
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        "Webview",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = Fonts.poppinsRegular(),
                        modifier = Modifier.padding(start = 12.dp, top = 2.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val state = rememberWebViewState(
                    url = "https://www.google.com/"
                )

                WebView(
                    state = state,
                    modifier = Modifier
                        .fillMaxSize()
                )

                if (state.isLoading)
                    LinearProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)
                    )
            }
        }
    }
}
