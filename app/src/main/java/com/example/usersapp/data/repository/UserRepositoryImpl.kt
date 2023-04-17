package com.example.usersapp.data.repository

import com.example.usersapp.data.api.UserApiClient
import com.example.usersapp.data.mappers.toDomain
import com.example.usersapp.domain.models.User
import com.example.usersapp.domain.repository.UserRepository
import com.example.usersapp.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: UserApiClient) :
    UserRepository {
    override suspend fun getAllUsers(): Response<List<User>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getAllUsers()

                val data =
                    response.body()?.map { it.toDomain() } ?: return@withContext Response.Failure(
                        NullPointerException()
                    )

                return@withContext Response.Success(data)
            } catch (e: Throwable) {
                return@withContext Response.Failure(e as Exception)
            }
        }
    }
}