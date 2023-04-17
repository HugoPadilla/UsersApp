package com.example.usersapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usersapp.domain.models.User

class MainViewModel : ViewModel() {
    val list = listOf(
        User(0, "Frank", "frand123", "email@e.com", "1212", "https:qwe.com"),
        User(0, "Frank", "frand123", "email@e.com", "1212", "https:qwe.com"),
        User(0, "Frank", "frand123", "email@e.com", "1212", "https:qwe.com")
    )

    private val _userList = MutableLiveData(list)
    val users: LiveData<List<User>> get() = _userList

    init {

    }
}