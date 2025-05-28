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
class DetailViewModel @Inject
    constructor(private val repository: NasaRepositoryImpl): ViewModel() {
    var detailUIState: DetailUIState by mutableStateOf(DetailUIState.Loading)
        private set
    private lateinit var currentImage: String

    fun getData(id: String) {
        viewModelScope.launch {
            detailUIState = try {
                val details = repository.getItem(id)
                currentImage = details[0].links?.get(0)?.href.toString()
                DetailUIState.Success(details, currentImage)
            } catch(e: IOException) {
                DetailUIState.Error
            }
        }
    }

    fun setCurrentImage(url: String) {
        var detailState = detailUIState
        currentImage = url
        if (detailState is DetailUIState.Success) {
            detailUIState = detailState.copy(
                currentImg = currentImage
            )
        }
    }
}