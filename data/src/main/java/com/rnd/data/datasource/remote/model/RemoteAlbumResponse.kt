package com.rnd.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteAlbumResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("title") val title: String
)