package com.example.dagh_hilt.retrofit

import com.example.dagh_hilt.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}