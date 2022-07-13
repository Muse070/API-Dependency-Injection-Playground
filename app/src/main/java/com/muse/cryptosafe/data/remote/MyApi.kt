package com.muse.cryptosafe.data.remote

import com.muse.cryptosafe.data.remote.dto.PostResponse

interface MyApi {
    suspend fun getPost(): List<PostResponse>
}