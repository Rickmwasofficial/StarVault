package com.example.starvault.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starvault.network.NasaRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: NasaRepositoryImpl
): ViewModel() {
    var homeUIState: HomeUIState by mutableStateOf(HomeUIState.Loading)
        private set

    init {
        getData(false)
    }

    private fun getData(isRefreshing: Boolean) {
        viewModelScope.launch {
            if (isRefreshing) {
                val currentState = homeUIState
                if (currentState is HomeUIState.Success) {
                    homeUIState = currentState.copy(isRefreshing = true)
                }
            }
            homeUIState = try {
                val listResult = repository.getData()
                val feedResult = repository.getFeed()
                val category1 = repository.getCategory()
                var category2 = repository.getCategory()
                if (category1 == category2) {
                    category2 = repository.getCategory()
                }
                HomeUIState.Success(feedResult, listResult, category1, category2, false)
            } catch(e: IOException) {
                HomeUIState.Error
            }
        }
    }

    fun refresh() {
        getData(true)
    }

    fun shuffleListData() {
        val currentState = homeUIState
        if (currentState is HomeUIState.Success) {
            homeUIState = currentState.copy(listData = currentState.listData.shuffled())
        }
    }
    fun shuffleCat1Data() {
        val currentState = homeUIState
        if (currentState is HomeUIState.Success) {
            homeUIState = currentState.copy(category1 = currentState.category1.shuffled())
        }
    }
    fun shuffleCat2Data() {
        val currentState = homeUIState
        if (currentState is HomeUIState.Success) {
            homeUIState = currentState.copy(category2 = currentState.category2.shuffled())
        }
    }
}