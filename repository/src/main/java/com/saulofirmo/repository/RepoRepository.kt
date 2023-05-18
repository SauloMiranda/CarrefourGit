package com.saulofirmo.repository

import com.saulofirmo.model.Repo

interface RepoRepository {

    suspend fun getRepoList(loginId: String): List<Repo>
}
