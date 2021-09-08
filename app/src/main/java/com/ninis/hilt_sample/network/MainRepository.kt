package com.ninis.hilt_sample.network

import com.ninis.hilt_sample.model.User
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getUser() : User {
        return apiService.getData()
    }
}