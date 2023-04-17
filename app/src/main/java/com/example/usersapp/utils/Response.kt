package com.example.usersapp.utils

sealed class Response<out T> {
    data class Success<out T>(
        val data: T? = null
    ): Response<T>()

    data class Failure(
        val e: Exception
    ): Response<Nothing>()
}