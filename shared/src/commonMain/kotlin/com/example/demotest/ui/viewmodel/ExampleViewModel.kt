package com.example.demotest.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.demotest.core.StringResources
import com.example.demotest.core.ViewModel
import com.example.demotest.core.formatString
import com.example.demotest.model.CatState
import com.example.demotest.repository.ExampleRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ExampleViewModel constructor(
    private val repository: ExampleRepository,
    private val stringResources: StringResources
) : ViewModel() {

    private val _catResponse: MutableState<CatState> = mutableStateOf(CatState())
    val catResponse: State<CatState> = _catResponse

    fun getCats() {
        viewModelScope.launch {
            repository.getCats()
                .onStart {
                    _catResponse.value = CatState(
                        isLoading = true
                    )
                }.catch {
                    _catResponse.value = CatState(
                        error = it.message ?: "Something went wrong!"
                    )
                }.collect {
                    _catResponse.value = CatState(
                        data = it
                    )
                    com.example.demotest.core.AndroidTimber.i("listSize: ${it.size}")
                }
        }
    }

    fun stringUsageExample() {
        println(stringResources.appBackground)
        println(stringResources.appBackgroundTemplate.formatString("1", "2"))
    }
}
