package com.rnd.domain.repository

import com.rnd.domain.core.ResultModel
import com.rnd.domain.model.Album
import com.rnd.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {

    fun getAlbums(): Flow<ResultModel<List<Album>>>

    fun getPhotos(): Flow<ResultModel<List<Photo>>>

}
