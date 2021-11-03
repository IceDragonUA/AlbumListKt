package com.rnd.domain.interactor

import com.rnd.domain.core.ResultModel
import com.rnd.domain.model.Album
import com.rnd.domain.model.Photo
import com.rnd.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Interactor(private val repository: NetworkRepository) {

    fun getAlbums(): Flow<ResultModel<List<Album>>> {
        return repository.getAlbums()
    }

    fun getPhotos(albumId: Int): Flow<ResultModel<List<Photo>>> {
        return repository.getPhotos().map {
            it.data = it.data?.filter { it.albumId == albumId}
            it
        }
    }
}
