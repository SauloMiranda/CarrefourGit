package com.saulofirmo.carrefourgitlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saulofirmo.model.User
import com.saulofirmo.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> = _userList

    suspend fun getUserList() {
        val users = userRepository.getUserList()
        _userList.postValue(users)
    }

    suspend fun getUserSearchList(name: String) {
        val users = userRepository.getUserSearchList(name)
        _userList.postValue(users)
    }
}
