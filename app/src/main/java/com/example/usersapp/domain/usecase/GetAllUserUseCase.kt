package com.example.usersapp.domain.usecase

import com.example.usersapp.domain.models.User
import com.example.usersapp.domain.repository.UserRepository
import com.example.usersapp.utils.Response
import javax.inject.Inject

class GetAllUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(): Response<List<User>> = userRepository.getAllUsers()
}