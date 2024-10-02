package com.example.dagh_hilt.retrofit

import com.example.dagh_hilt.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun fetchUsers(): List<User> {
        return apiService.getUsers()
    }
}