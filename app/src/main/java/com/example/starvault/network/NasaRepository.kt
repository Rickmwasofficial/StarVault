package com.example.starvault.network

import ItemsData
import com.example.starvault.network.NasaApi.retrofitService

interface NasaRepository {
    suspend fun getData(): List<ItemsData>
    suspend fun getFeed(): List<ItemsData>
}

class NasaRepositoryImpl(): NasaRepository {
    override suspend fun getData(): List<ItemsData> {
        return retrofitService.getPhotos().collection.items
    }

    override suspend fun getFeed(): List<ItemsData> {
        return retrofitService.getFeedPhotos().collection.items
    }
}