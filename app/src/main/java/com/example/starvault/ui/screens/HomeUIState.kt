package com.example.starvault.ui.screens

import ItemsData

sealed interface HomeUIState {
    data class Success(val data: List<ItemsData>,
                       val listData: List<ItemsData>,
                        val category1: List<ItemsData>,
                        val category2: List<ItemsData>,
                       val isRefreshing: Boolean = false
    ): HomeUIState
    object Error: HomeUIState
    object Loading: HomeUIState
}