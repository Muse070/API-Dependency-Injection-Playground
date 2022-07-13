package com.muse.cryptosafe.domain.repository

import com.muse.cryptosafe.data.remote.dto.PostResponse
import dagger.Provides

interface MyRepository {
    suspend fun getPosts(): List<PostResponse>
}