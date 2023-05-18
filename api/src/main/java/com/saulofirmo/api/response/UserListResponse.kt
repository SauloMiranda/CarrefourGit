package com.saulofirmo.api.response

import com.squareup.moshi.Json

data class UserListResponse(

    @Json(name = "login")
    val login: String,

    @Json(name = "avatar_url")
    val avatarUrl: String? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "site_admin")
    val siteAdmin: Boolean? = null
)
