package com.example.usersapp.data.repository

import com.example.usersapp.domain.models.User
import com.example.usersapp.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {
    override suspend fun getAllUsers(): List<User> {
        TODO("Not yet implemented")
    }
}