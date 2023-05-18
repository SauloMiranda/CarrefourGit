package com.saulofirmo.model

data class User(

    val login: String,
    val avatarUrl: String? = null,
    val type: String? = null,
    val siteAdmin: Boolean? = null,
    val name: String? = null,
    val company: String? = null,
    val blog: String? = null,
    val location: String? = null,
    val createdAt: String? = null
)
