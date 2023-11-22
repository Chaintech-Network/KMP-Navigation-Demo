package com.example.demotest.ui.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import com.example.demotest.core.Fonts
import com.example.demotest.navigation.LocalNavigation


class SampleBottomSheet : Screen {
    @Composable
    override fun Content() {
        val navigation = LocalNavigation.current
        val bottomSheetNavigator = LocalBottomSheetNavigator.current

        LifecycleEffect(
            onStarted = { },
            onDisposed = { }
        )

        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f).background(Color(0xFFF9F7EA)),
            contentAlignment = Alignment.Center
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(Color(0xFF333333)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.height(44.dp),
                onClick = {
                    bottomSheetNavigator.hide()
                    navigation.goToWebView()
                },
            ) {
                Text(
                    "Open WebView Screen",
                    fontFamily = Fonts.poppinsRegular(),
                    fontSize = 16.sp
                )
            }
        }
    }
}
