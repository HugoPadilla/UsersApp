package com.example.usersapp.di

import com.example.usersapp.data.repository.UserRepositoryImpl
import com.example.usersapp.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppRepositoryModule {
    @Binds
    abstract fun bindCatRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}