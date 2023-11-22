package com.example.demotest.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.example.demotest.core.FromRemote
import com.example.demotest.navigation.LocalNavigation

class DetailScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigation.current
        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFFF9F7EA))
                .verticalScroll(rememberScrollState())
        ) {
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
                            navigator.back()
                        },
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        "Detail Screen",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = Fonts.poppinsRegular(),
                        modifier = Modifier.padding(start = 12.dp, top = 2.dp)
                    )
                }
            }

            /*FromRemote(
                painterResource = "https://artofpresentations.com/wp-content/uploads/2021/09/Featured-Image-Placeholders-in-PowerPoint.jpg",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(top = 14.dp, start = 16.dp, end = 16.dp).fillMaxWidth()
                    .height(250.dp).clip(RoundedCornerShape(12.dp)),
                showPlaceHolder = true
            )*/
            FromLocalDrawable(
                painterResource = "img_banner.webp",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(top = 14.dp, start = 16.dp, end = 16.dp).fillMaxWidth()
                    .height(250.dp).clip(RoundedCornerShape(12.dp))
            )

            Text(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\n" +
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = Fonts.poppinsRegular(),
                modifier = Modifier.padding(top = 14.dp, bottom = 20.dp, start = 16.dp, end = 16.dp)
            )
        }


    }
}
