package com.saulofirmo.api

import com.saulofirmo.api.response.RepoResponse
import com.saulofirmo.api.response.UserDetailResponse
import com.saulofirmo.api.response.UserListResponse
import com.saulofirmo.api.response.UserSearchResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getUserList(
        @Header("Authorization") authorization: String?
    ): Single<List<UserListResponse>>

    @GET("users/{user_name}")
    fun getUserDetail(
        @Header("Authorization") authorization: String?,
        @Path("user_name") userName: String
    ): Single<UserDetailResponse>

    @GET("/users/{user_login}/repos")
    fun getUserRepos(
        @Header("Authorization") authorization: String?,
        @Path("user_login") userLogin: String
    ): Single<List<RepoResponse>>

    @GET("/search/users")
    fun searchUsers(
        @Header("Authorization") authorization: String?,
        @Query("q") query: String
    ): Single<UserSearchResponse>
}
