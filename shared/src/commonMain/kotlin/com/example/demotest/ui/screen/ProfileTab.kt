package com.example.demotest.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.demotest.core.Fonts

internal object ProfileTab : Tab {
    @Composable
    override fun Content() {
        Profile()
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Rounded.AccountCircle)

            return remember { TabOptions(index = 0u, title = "Profile", icon = icon) }
        }
}

@Composable
fun Profile() {
    Column(
        Modifier.fillMaxSize().background(Color(0xFFF9F7EA)),
        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "Cats",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp,
            fontFamily = Fonts.poppinsRegular(),
            modifier = Modifier.padding(top=12.dp, start = 16.dp)
        )
        CatList()
    }
}


