package com.muse.cryptosafe.data.remote.dto

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.muse.cryptosafe.domain.model.Post
import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
   // @SerializedName("userId")
    val userId: String,
    //@SerializedName("id")
    val id: String,
    //@SerializedName("title")
    val title: String,
    //@SerializedName("body")
    val body: String
) {
    fun toPost(): Post {
        return Post(
            userId = userId,
            title = title,
            body = body
        )
    }
}
