# KMP(Kotlin Multi Platfrom) Demo

This SampleApp is built with Compose multiplatform based on MVVM architecture, which covers
- Coroutines
- Navigation 
- Flow
- Material3 
- Koin
- Api Calling
- Network Image Loading
- Kotlin Serialization


https://github.com/ChainTechNetwork/KMP-Navigation-Demo/assets/143475887/9d3fd618-b162-492d-90ce-6bcc9c708c31


**Open-source libraries Used in this Demo**

- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization): Kotlin multiplatform / multi-format serialization.
- [Compose multiplatform](https://github.com/JetBrains/compose-multiplatform): a modern UI framework for Kotlin.
- [Voyager](https://github.com/adrielcafe/voyager): for navigation.
- [Ktor](https://github.com/ktorio/ktor): for making network requests.
- [Koin](https://github.com/InsertKoinIO/koin): a pragmatic lightweight dependency injection framework.
- [Material 3](https://m3.material.io/components): Material 3 components
- [MVVM](https://github.com/ahmedeltaher/MVVM-Kotlin-Android-Architecture): Project Architecture
- [Image](https://github.com/qdsfdhvh/compose-imageloader): Remote Image Loading

Other

- Logger: Kotlin multi platform logging
- Webview: for web url loading
- Bottomsheet
- Resources: (Use custom fonts, add images(png,xml), Use string resources with multi language)

**for networking:**

[https://api.thecatapi.com/v1/images/search?limit=20](https://api.thecatapi.com/v1/images/search?limit=20)

**Voyager**

For bottomTab navigation, screen navigation, bottomSheet Navigation follow below

Step:1

commonMain
```
// Multiplatform
// Navigator
implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
// BottomSheetNavigator
implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:$voyagerVersion")
// TabNavigator
implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")
// Transitions
implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")
```

Step:2

-\> [Core Logic](https://github.com/ChainTechNetwork/KMP-Navigation-Demo/tree/main/shared/src/commonMain/kotlin/com/example/demotest/navigation)

-\> [Initialization](https://github.com/ChainTechNetwork/KMP-Navigation-Demo/blob/main/shared/src/commonMain/kotlin/com/example/demotest/App.kt)

-\> [Usage](https://github.com/ChainTechNetwork/KMP-Navigation-Demo/blob/main/shared/src/commonMain/kotlin/com/example/demotest/ui/screen/ProfileTab.kt)

**ImageLoader**
```
api("io.github.qdsfdhvh:image-loader:1.6.7")
```

Example [ImageView.kt](https://github.com/ChainTechNetwork/KMP-Navigation-Demo/blob/main/shared/src/commonMain/kotlin/com/example/demotest/core/ImageView.kt)

**Ktor**

commonMain
```
implementation("io.ktor:ktor-client-core:2.3.6")
implementation("io.ktor:ktor-client-content-negotiation:2.3.6")
implementation("io.ktor:ktor-client-logging:2.3.6")
api("io.ktor:ktor-serialization-kotlinx-json:2.3.6")
```
androidMain
```
implementation("io.ktor:ktor-client-android:2.3.3")
implementation("io.ktor:ktor-client-okhttp:2.3.3")
```
iOSMain
```
implementation("io.ktor:ktor-client-darwin:2.3.3")
```
For Api calling [Follow](https://github.com/ChainTechNetwork/KMP-Navigation-Demo/blob/main/shared/src/commonMain/kotlin/com/example/demotest/ui/viewmodel/ExampleViewModel.kt)

**Serialization**

commonMain
```
implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
```

[Example](https://github.com/ChainTechNetwork/KMP-Navigation-Demo/blob/main/shared/src/commonMain/kotlin/com/example/demotest/model/Cat.kt)

**Koin**

commonMain
```
implementation("io.insert-koin:koin-core:3.4.3")
implementation("io.insert-koin:koin-compose:1.0.4")
```

androidMain
```
implementation("io.insert-koin:koin-android:3.4.3")
```

**String Resources**

Follow [StringRes.kt](https://github.com/ChainTechNetwork/KMP-Navigation-Demo/blob/main/shared/src/commonMain/kotlin/com/example/demotest/core/StringRes.kt)

**CustomFont**

Add font in commonMain -\> resources (if not create)-\> create font directory and add fonts

[Example](https://github.com/ChainTechNetwork/KMP-Navigation-Demo/blob/main/shared/src/commonMain/kotlin/com/example/demotest/core/Font.kt)

**Drawable**

Add font in commonMain -\> resources (if not create)-\> add images

[Example](https://github.com/ChainTechNetwork/KMP-Navigation-Demo/blob/main/shared/src/commonMain/kotlin/com/example/demotest/ui/screen/Detail.kt)

**[Follow us on Linkedin for more such useful content](https://www.linkedin.com/showcase/mobile-innovation-network/?viewAsMember=true)**
