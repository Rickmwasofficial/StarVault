package com.example.starvault.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starvault.network.NasaRepositoryImpl
import kotlinx.coroutines.launch
import okio.IOException

class DetailViewModel(): ViewModel() {
    var detailUIState: DetailUIState by mutableStateOf(DetailUIState.Loading)
        private set

    fun getData(id: String) {
        viewModelScope.launch {
            detailUIState = try {
                val repository = NasaRepositoryImpl()
                val details = repository.getItem(id)
                DetailUIState.Success(details)
            } catch(e: IOException) {
                DetailUIState.Error
            }
        }
    }
}