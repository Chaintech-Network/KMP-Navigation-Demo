package com.example.demotest.di

import com.example.demotest.core.StringResources
import com.example.demotest.core.stringResourcesDe
import com.example.demotest.core.stringResourcesEn
import com.example.demotest.core.viewModelDefinition
import com.example.demotest.network.ApiService
import com.example.demotest.network.BASE_URL
import com.example.demotest.repository.ExampleRepository
import com.example.demotest.ui.viewmodel.ExampleViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun appModule() = module {
    single { createJson() }
    single { createHttpClient(get()) }
    single { ApiService(get()) }
    factory { ExampleRepository(get()) }
    single { stringResourcesEn() }
    single(named("de")) { stringResourcesDe() }

    viewModelDefinition {(language: String) ->
        val stringResources: StringResources = if (language == "DE") get(named("de")) else get()
        ExampleViewModel(get(), stringResources)
    }
}

fun createJson(): Json = Json { isLenient = true; ignoreUnknownKeys = true }

fun createHttpClient(json: Json): HttpClient = HttpClient {

    defaultRequest {
        url(BASE_URL)
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
    }

    install(ContentNegotiation) {
        json(json)
    }

    install(DefaultRequest) {
        headers.apply {
            append("content-type", "application/json")
        }
    }

    install(Logging) {
        logger = DebugKtorLogger()
        level = LogLevel.BODY
    }

}
class DebugKtorLogger : Logger {
    override fun log(message: String) {
        println("Ktor OkHttp\n$message")
    }
}