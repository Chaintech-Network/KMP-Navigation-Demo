package com.example.demotest.network

import com.example.demotest.model.Cat
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

val BASE_URL = "https://api.thecatapi.com/v1/"

class ApiService(private val client: HttpClient) {
    private val catUrl = "images/search?limit=20"

    suspend fun getCats(): List<Cat> {
        return client.get {
            url(catUrl)
        }.body()
    }
}