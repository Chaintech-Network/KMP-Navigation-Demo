package com.example.demotest.model

data class CatState(
    val data: List<Cat> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)