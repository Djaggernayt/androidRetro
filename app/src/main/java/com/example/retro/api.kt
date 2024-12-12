package com.example.retro

import retrofit2.Response
import retrofit2.http.GET

interface api {
    @GET("photos")
    suspend fun getMarsPhoto(): Response<List<MarsPhoto>>
    @GET("realestate")
    suspend fun getMars(): Marses
}
data class Mars(
    val price:String, val id: String, val type:String,  val img_src: String
)
data class Marses(
    val mar: List<Mars>
)
data class MarsPhoto(
    val id: String,  val img_src: String
)
data class MarsPhotos(
    val photos: List<MarsPhoto>
)