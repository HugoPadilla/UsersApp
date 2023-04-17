package com.example.usersapp.data.mappers

import com.example.usersapp.data.api.dto.UserResponseItem
import com.example.usersapp.domain.models.User

fun UserResponseItem.toDomain(): User {
    return User(
        id = id ?: -1,
        name = name ?: "",
        username = username ?: "",
        email = email ?: "",
        phone = phone ?: "",
        website = website?: ""
    )
}