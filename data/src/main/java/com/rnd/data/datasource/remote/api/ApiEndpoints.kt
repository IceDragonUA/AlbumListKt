package com.rnd.data.datasource.remote.api

import com.rnd.data.datasource.remote.model.RemoteAlbumResponse
import com.rnd.data.datasource.remote.model.RemotePhotoResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndpoints {

    @GET("/albums")
    suspend fun getAlbums(): Response<List<RemoteAlbumResponse>>

    @GET("/photos")
    suspend fun getPhotos(): Response<List<RemotePhotoResponse>>
}
