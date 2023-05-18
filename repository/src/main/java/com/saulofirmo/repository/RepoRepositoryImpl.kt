package com.saulofirmo.repository

import com.saulofirmo.api.ApiService
import com.saulofirmo.model.Repo
import kotlinx.coroutines.rx2.await
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : RepoRepository {

    companion object {
        private const val GITHUB_ACCESS_TOKEN = "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"
    }

    override suspend fun getRepoList(loginId: String): List<Repo> {
        val authorization = GITHUB_ACCESS_TOKEN.ifBlank { null }
        val response = apiService.getUserRepos(authorization, loginId).await()

        return response.map {
            Repo(
                id = it.id,
                name = it.name,
                fullName = it.fullName,
                description = it.description,
                htmlUrl = it.htmlUrl
            )
        }
    }
}
