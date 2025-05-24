package com.example.starvault.ui.screens

import ItemsData

sealed interface HomeUIState {
    data class Success(val data: List<ItemsData>, val listData: List<ItemsData>): HomeUIState
    object Error: HomeUIState
    object Loading: HomeUIState
}