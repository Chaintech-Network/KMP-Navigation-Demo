package com.example.demotest.repository

import com.example.demotest.model.Cat
import com.example.demotest.network.ApiService
import kotlinx.coroutines.flow.flow

class ExampleRepository constructor(private val apiService: ApiService) {

    suspend fun getCats() = flow<List<Cat>> {
        emit(apiService.getCats())
    }
}
