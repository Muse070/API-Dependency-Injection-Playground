package com.muse.cryptosafe.data.repository

import com.muse.cryptosafe.data.remote.RetrofitApi
import com.muse.cryptosafe.data.remote.dto.PostResponse
import retrofit2.Call
import javax.inject.Inject

class RetrofitImpl @Inject constructor(
    private val retrofitApi: RetrofitApi
): RetrofitApi {

    override suspend fun getUser(): List<PostResponse> {
        return retrofitApi.getUser()
   }
}