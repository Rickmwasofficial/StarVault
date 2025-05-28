package com.example.starvault.network

import NasaData
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import retrofit2.http.GET
import retrofit2.http.Query

val nasaSearchCategories = listOf(
    // 🚀 Space Missions
    "Apollo 11",
    "Artemis",
    "Voyager",
    "Mars 2020",
    "James Webb Space Telescope",
    "Curiosity Rover",
    "Hubble Space Telescope",
    "Perseverance Rover",
    "International Space Station",
    "Space Shuttle",

    // 🌌 Astronomy & Universe
    "Nebula",
    "Galaxy",
    "Black Hole",
    "Supernova",
    "Andromeda",
    "Milky Way",
    "Exoplanets",
    "Pulsar",
    "Cosmic Microwave Background",
    "Gravitational Waves",

    // 🪐 Planets & Moons
    "Earth",
    "Mars",
    "Jupiter",
    "Saturn Rings",
    "Uranus",
    "Neptune",
    "Venus",
    "Pluto",
    "Titan",
    "Europa",

    // 🌍 Earth Science & Views from Space
    "Hurricanes",
    "Climate Change",
    "Aurora Borealis",
    "Ocean Currents",
    "Volcanoes",
    "Coral Reefs",
    "Deforestation",
    "Night Earth",
    "Earth Observation",
    "Earth from Space",

    // 👨‍🚀 Human Spaceflight
    "Astronaut",
    "EVA",
    "Zero Gravity",
    "Training",
    "Launch",
    "Spacewalk",
    "Space Suit",
    "ISS Interior",

    // 🔬 Technology & Engineering
    "Satellite",
    "Rocket",
    "Launchpad",
    "Spacecraft",
    "Robotics",
    "Telemetry",
    "Mission Control",
    "Space Probe",

    // 🧬 Science & Education
    "STEM",
    "NASA Classroom",
    "Science Experiment",
    "3D Printing in Space",
    "Space Agriculture",
    "Biology in Space",
    "Microgravity",
    "Student Projects"
)



interface NasaApiService {
    @GET("search")
    suspend fun getPhotos(
        @Query("q") q: String = "",
        @Query("media_type") mediaType: String = "image",
        @Query("year_start") year: String = "2025"
    ): NasaData
    @GET("search")
    suspend fun getFeedPhotos(
        @Query("keywords") q: String = nasaSearchCategories.random(),
        @Query("media_type") mediaType: String = "image"
    ): NasaData
    @GET("search")
    suspend fun getCategory(
        @Query("q") q: String = "",
        @Query("media_type") mediaType: String = "image",
        @Query("keywords") kw: String = nasaSearchCategories.random()
    ): NasaData
    @GET("search")
    suspend fun getItem(
        @Query("media_type") mediaType: String = "image",
        @Query("nasa_id") id: String
    ): NasaData
}
