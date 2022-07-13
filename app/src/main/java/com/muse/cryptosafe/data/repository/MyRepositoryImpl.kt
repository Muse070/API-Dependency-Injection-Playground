package com.muse.cryptosafe.data.repository

import com.muse.cryptosafe.data.remote.dto.PostResponse
import com.muse.cryptosafe.data.source.HttpRoutes
import com.muse.cryptosafe.domain.repository.MyRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class MyRepositoryImpl(
    private val client: HttpClient
): MyRepository {
    override suspend fun getPosts(): List<PostResponse> {
        val request = client.get(HttpRoutes.POST)
        return request.body()
    }
}