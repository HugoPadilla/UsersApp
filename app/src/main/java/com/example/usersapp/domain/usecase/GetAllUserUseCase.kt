package com.example.usersapp.domain.usecase

import com.example.usersapp.domain.repository.UserRepository
import javax.inject.Inject

class GetAllUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke() = userRepository.getAllUsers()
}