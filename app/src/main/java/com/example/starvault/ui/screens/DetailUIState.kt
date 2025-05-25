package com.example.starvault.ui.screens

import ItemsData

sealed interface DetailUIState {
    data class Success(val data: List<ItemsData>): DetailUIState
    object Error: DetailUIState
    object Loading: DetailUIState
}