package com.example.starvault.network

import NasaData
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://images-api.nasa.gov/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface NasaApiService {
    @GET("search")
    suspend fun getPhotos(
        @Query("q") q: String = "",
        @Query("media_type") mediaType: String = "image",
        @Query("year_start") year: String = "2025"
    ): NasaData
    @GET("search")
    suspend fun getFeedPhotos(
        @Query("title") q: String = "stars",
        @Query("media_type") mediaType: String = "image"
    ): NasaData
}

object NasaApi {
    val retrofitService: NasaApiService by lazy {
        retrofit.create(NasaApiService::class.java)
    }
}
