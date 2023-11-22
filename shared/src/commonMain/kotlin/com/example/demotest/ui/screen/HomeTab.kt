package com.example.demotest.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.demotest.core.Fonts.poppinsRegular
import com.example.demotest.core.FromLocalDrawable
import com.example.demotest.ui.bottomsheet.SampleBottomSheet
import com.example.demotest.core.FromRemote
import com.example.demotest.core.LocalStringResources
import com.example.demotest.navigation.LocalNavigation
import com.example.demotest.ui.viewmodel.ExampleViewModel
import org.koin.compose.rememberKoinInject
import org.koin.core.parameter.parametersOf

internal object HomeTab : Tab {
    @Composable
    override fun Content() {
        Home()
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Rounded.Home)

            return remember { TabOptions(index = 0u, title = "Home", icon = icon) }
        }

}

@Composable
fun Home() {
    val navigator = LocalNavigation.current
    val bottomSheetNavigator = LocalBottomSheetNavigator.current
    val stringRes = LocalStringResources.current
    Column(
        Modifier.fillMaxSize().background(Color(0xFFF9F7EA)).padding(start = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.weight(0.1f))
        Text(
            stringRes.labelHomeScreen,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp,
            fontFamily = poppinsRegular()
        )
        Spacer(Modifier.weight(0.4f))
        FromLocalDrawable(
            painterResource = "img_banner.webp",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                .height(250.dp).clip(RoundedCornerShape(12.dp))
        )
        Button(
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth().height(44.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF333333)),
            onClick = {
                navigator.goToDetail()
            },
        ) {
            Text(
                stringRes.labelDetailScreen,
                fontFamily = poppinsRegular(),
                fontSize = 16.sp
            )
        }
        Button(
            modifier = Modifier.padding(top = 12.dp).fillMaxWidth().height(44.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF333333)),
            onClick = {
                bottomSheetNavigator.show(SampleBottomSheet())
            },
        ) {
            Text(
                "Open BottomSheet",
                fontFamily = poppinsRegular(),
                fontSize = 16.sp
            )
        }
        Spacer(Modifier.weight(0.6f))
    }
}

@Composable
fun CatList() {
    val exampleViewModel =
        rememberKoinInject<ExampleViewModel>(
            parameters = { parametersOf("EN") },
        )

    LaunchedEffect(Unit) {
        exampleViewModel.getCats()
    }

    val list = exampleViewModel.catResponse.value.data

    if (exampleViewModel.catResponse.value.isLoading) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                color = Color(0xFF333333),
                strokeWidth = 4.dp,
                modifier = Modifier.size(50.dp)
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            itemsIndexed(list) { index, item ->
                FromRemote(
                    painterResource = item.url ?: "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxWidth().height(180.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            2.dp, Color(0xFFE8E8E8),
                            RoundedCornerShape(12.dp)
                        ),
                    showPlaceHolder = true
                )
            }
        }
    }

}



