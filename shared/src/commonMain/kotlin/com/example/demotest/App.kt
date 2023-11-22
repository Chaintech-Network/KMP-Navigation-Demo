package com.example.demotest

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.demotest.core.ApplicationTheme
import com.example.demotest.core.Fonts
import com.example.demotest.di.appModule
import com.example.demotest.navigation.LocalNavigation
import com.example.demotest.navigation.LocalScreenContainer
import com.example.demotest.navigation.NavigationProvider
import com.example.demotest.navigation.ScreenContainerProvider
import com.example.demotest.ui.screen.HomeTab
import com.example.demotest.ui.screen.ProfileTab
import com.example.demotest.theme.MoviesAppTheme
import org.koin.compose.KoinApplication


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App() {
    MoviesAppTheme {
        KoinApplication(application = { modules(appModule()) }) {
            ApplicationTheme {
                val navigation = remember { NavigationProvider() }
                val screenContainer = remember { ScreenContainerProvider() }
                CompositionLocalProvider(
                    LocalScreenContainer provides screenContainer,
                    LocalNavigation provides navigation,
                ) {
                    BottomSheetNavigator(
                        modifier = Modifier.animateContentSize(),
                        sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                        skipHalfExpanded = true
                    ) {
                        TabNavigator(HomeTab) {
                            Navigator(Application()) {
                                navigation.initialize()
                                SlideTransition(it)
                            }
                        }
                    }
                }
            }
        }
    }
}

class Application : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            modifier = Modifier,
            scaffoldState = rememberScaffoldState(),
            bottomBar = {
                BottomNavigation(
                    modifier = Modifier,
                    backgroundColor = MaterialTheme.colors.surface,
                    elevation = 4.dp,
                ) {
                    TabNavigationItem(tab = HomeTab)
                    TabNavigationItem(tab = ProfileTab)
                }
            },
        ) {
            CurrentTab()
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val title = tab.options.title
    BottomNavigationItem(
        modifier = Modifier.background(Color(0xFF333333)),
        alwaysShowLabel = true,
        label = {
            Text(
                text = title,
                fontFamily = Fonts.poppinsRegular(),
            )
        },
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) },
        selectedContentColor = Color.White,
        unselectedContentColor = Color.LightGray
    )
}
