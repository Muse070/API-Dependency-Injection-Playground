package com.muse.cryptosafe.data.remote

import com.muse.cryptosafe.data.remote.dto.PostResponse
import retrofit2.http.GET

interface RetrofitApi {
    @GET("/posts")
    suspend fun getUser(): List<PostResponse>
}
