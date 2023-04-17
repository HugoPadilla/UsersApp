package com.example.usersapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usersapp.domain.models.User
import com.example.usersapp.domain.usecase.GetAllUserUseCase
import com.example.usersapp.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllUserUseCase: GetAllUserUseCase
) : ViewModel() {

    private val _userList = MutableLiveData<List<User>>(listOf())
    val users: LiveData<List<User>> get() = _userList

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        changeUsers()
    }

    private fun changeUsers() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            try {
                when (val result = getAllUserUseCase()) {
                    is Response.Failure -> {
                        _isLoading.postValue(false)
                    }
                    is Response.Success -> {
                        _isLoading.postValue(false)
                        _userList.postValue(result.data.orEmpty())
                    }
                }
            } catch (e: Exception) {
                _isLoading.postValue(false)
            }
        }
    }
}