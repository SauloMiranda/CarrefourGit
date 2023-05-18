package com.saulofirmo.repository

import com.saulofirmo.model.User

interface UserRepository {

    suspend fun getUserList(): List<User>

    suspend fun getUserSearchList(name: String): List<User>

    suspend fun getUserDetail(loginId: String): User
}
