package com.rnd.data.repository

import com.rnd.data.common.RepositoryBaseImpl
import com.rnd.data.datasource.remote.api.ApiEndpoints
import com.rnd.data.mapper.NetworkAlbumMapper
import com.rnd.data.mapper.NetworkPhotoMapper
import com.rnd.domain.core.ResultModel
import com.rnd.domain.model.Album
import com.rnd.domain.model.Photo
import com.rnd.domain.repository.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class NetworkRepositoryImpl(
    private val api: ApiEndpoints,
    private val albumMapper: NetworkAlbumMapper,
    private val photoMapper: NetworkPhotoMapper
) : RepositoryBaseImpl(), NetworkRepository {

    override fun getAlbums(): Flow<ResultModel<List<Album>>> {
        return flow {
            emit(ResultModel.loading())
            val result = getResponse({ api.getAlbums() }, albumMapper)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override fun getPhotos(): Flow<ResultModel<List<Photo>>> {
        return flow {
            emit(ResultModel.loading())
            val result = getResponse({ api.getPhotos() }, photoMapper)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}
