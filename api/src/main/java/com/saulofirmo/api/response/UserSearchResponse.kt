package com.saulofirmo.api.response

import com.squareup.moshi.Json

class UserSearchResponse {

    @Json(name = "total_count")
    var totalCount:Int = 0

    var items: List<UserDetailResponse>? = null
}