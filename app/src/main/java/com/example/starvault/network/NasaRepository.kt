package com.example.starvault.network

import ItemsData
import com.example.starvault.network.NasaApi.retrofitService

interface NasaRepository {
    suspend fun getData(): List<ItemsData>
    suspend fun getFeed(): List<ItemsData>
    suspend fun getCategory(): List<ItemsData>
    suspend fun getItem(id: String): List<ItemsData>
}

class NasaRepositoryImpl(): NasaRepository {
    private fun List<ItemsData>.filterValidItems(): List<ItemsData> {
        return filter { item ->
            item.data.isNotEmpty() && item.data[0].nasaId.isNotBlank() &&
            !item.data[0].title.isNullOrBlank() &&
            item.links?.isNotEmpty() == true
        }
    }

    override suspend fun getData(): List<ItemsData> {
        return retrofitService.getPhotos().collection.items.shuffled().filterValidItems()
    }

    override suspend fun getFeed(): List<ItemsData> {
        return retrofitService.getFeedPhotos().collection.items.shuffled().filterValidItems()
    }

    override suspend fun getCategory(): List<ItemsData> {
        return retrofitService.getCategory().collection.items.shuffled().filterValidItems()
    }

    override suspend fun getItem(id: String): List<ItemsData> {
        return retrofitService.getItem(id = id).collection.items.shuffled().filterValidItems()
    }
}