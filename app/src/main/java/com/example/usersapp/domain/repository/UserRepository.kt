package com.example.usersapp.domain.repository

import com.example.usersapp.domain.models.User

interface UserRepository {

    suspend fun getAllUsers(): List<User>

}