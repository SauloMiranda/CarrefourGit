package com.saulofirmo.carrefourgitlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saulofirmo.model.Repo
import com.saulofirmo.model.User
import com.saulofirmo.repository.RepoRepository
import com.saulofirmo.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val repoRepository: RepoRepository
) : ViewModel() {

    private val _userDetail = MutableLiveData<User>()
    private val _repoList = MutableLiveData<List<Repo>>()
    val userDetail: LiveData<User> = _userDetail
    val repos: LiveData<List<Repo>> = _repoList


    suspend fun getUserDetail(loginId: String) {
        val user = userRepository.getUserDetail(loginId)
        _userDetail.postValue(user)
    }

    suspend fun getRepos(loginId: String) {
        val repo = repoRepository.getRepoList(loginId)
        _repoList.postValue(repo)
    }
}
