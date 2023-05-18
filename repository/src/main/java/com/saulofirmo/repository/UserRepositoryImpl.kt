package com.saulofirmo.repository

import com.saulofirmo.api.ApiService
import com.saulofirmo.model.User
import kotlinx.coroutines.rx2.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {

    companion object {
        private const val GITHUB_ACCESS_TOKEN = "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"
    }

    override suspend fun getUserList(): List<User> {
        val authorization = GITHUB_ACCESS_TOKEN.ifBlank { null }
        val response = apiService.getUserList(authorization).await()
        return response.map {
            User(
                login = it.login,
                avatarUrl = it.avatarUrl
            )
        }
    }

    override suspend fun getUserSearchList(name: String): List<User> {
        val authorization = GITHUB_ACCESS_TOKEN.ifBlank { null }
        val response = apiService.searchUsers(authorization, name).await()
        return response.items?.map {
            User(
                login = it.login,
                avatarUrl = it.avatarUrl
            )
        }!!
    }

    override suspend fun getUserDetail(loginId: String): User {
        val authorization = GITHUB_ACCESS_TOKEN.ifBlank { null }
        val response = apiService.getUserDetail(authorization, loginId).await()
        return User(
            login = response.login,
            avatarUrl = response.avatarUrl,
            type = response.type,
            siteAdmin = response.siteAdmin,
            name = response.name,
            company = response.company,
            blog = response.blog,
            location = response.location,
            createdAt = response.createdAt
        )
    }
}
