package com.saulofirmo.api.response

import com.squareup.moshi.Json

class RepoResponse {
    var id: Long = 0
    var name: String? = null
    @Json(name = "full_name")
    var fullName: String? = null
    var description: String? = null
    @Json(name = "html_url")
    var htmlUrl: String? = null
}