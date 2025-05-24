package com.example.starvault.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starvault.network.NasaRepositoryImpl
import kotlinx.coroutines.launch
import okio.IOException

class HomeViewModel(): ViewModel() {
    var homeUIState: HomeUIState by mutableStateOf(HomeUIState.Loading)
        private set

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            homeUIState = try {
                val repository = NasaRepositoryImpl()
                val listResult = repository.getData()
                val feedResult = repository.getFeed()
                HomeUIState.Success(feedResult, listResult)
            } catch(e: IOException) {
                HomeUIState.Error
            }
        }
    }

    fun refresh() {
        getData()
    }
}