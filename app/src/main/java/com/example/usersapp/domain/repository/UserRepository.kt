package com.example.usersapp.domain.repository

import com.example.usersapp.domain.models.User
import com.example.usersapp.utils.Response

interface UserRepository {

    suspend fun getAllUsers(): Response<List<User>>

}