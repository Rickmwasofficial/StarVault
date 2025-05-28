package com.example.starvault.ui.screens

import ItemsData

sealed interface SearchUiState {
    data class Success(val results: List<ItemsData>, val keywords: MutableList<String>): SearchUiState
    object Error: SearchUiState
    object Loading: SearchUiState
}