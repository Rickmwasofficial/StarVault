package com.example.starvault.di

import com.example.starvault.network.NasaApiService
import com.example.starvault.network.NasaRepositoryImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

private const val BASE_URL = "https://images-api.nasa.gov/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providesNasaApiService(retrofit: Retrofit): NasaApiService {
        return retrofit.create(NasaApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesNasaRepositoryImpl(api: NasaApiService): NasaRepositoryImpl {
        return NasaRepositoryImpl(api)
    }
}