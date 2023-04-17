package com.example.usersapp.data.api

import com.example.usersapp.data.api.dto.UserResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface UserApiClient {

    @GET("users")
    suspend fun getAllUsers(): Response<List<UserResponseItem>>

}