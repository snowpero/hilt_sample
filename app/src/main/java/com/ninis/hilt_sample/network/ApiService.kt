package com.ninis.hilt_sample.network

import com.ninis.hilt_sample.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("posts/1")
    suspend fun getData(): User
}