package com.saulofirmo.api.response

import com.squareup.moshi.Json

data class UserDetailResponse(

    @Json(name = "login")
    val login: String,

    @Json(name = "avatar_url")
    val avatarUrl: String? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "site_admin")
    val siteAdmin: Boolean? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "company")
    val company: String? = null,

    @Json(name = "blog")
    val blog: String? = null,

    @Json(name = "location")
    val location: String? = null,

    @Json(name = "created_at")
    val createdAt: String? = null
)
