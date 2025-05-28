package com.example.starvault.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starvault.network.NasaRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: NasaRepositoryImpl
): ViewModel() {
    var searchUiState: SearchUiState by mutableStateOf(SearchUiState.Success(listOf(), mutableListOf()))
        private set

    init {
        getKeywords()
    }

    private fun getKeywords() {
        viewModelScope.launch {
            val listResult = repository.getData()
            var searchState = searchUiState
            if (searchState is SearchUiState.Success) {
                listResult.forEach {
                    it.data[0].keywords?.forEach { elem ->
                        if (elem !in searchState.keywords) {
                            searchState.keywords.add(elem)
                        }
                    }
                }
            }
        }
    }
}