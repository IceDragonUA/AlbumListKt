package com.rnd.data.mapper

import com.rnd.data.common.RemoteEntityToDomainMapper
import com.rnd.data.datasource.remote.model.RemotePhotoResponse
import com.rnd.domain.model.Photo

class NetworkPhotoMapper: RemoteEntityToDomainMapper<List<RemotePhotoResponse>, List<Photo>> {

    override fun map(input: List<RemotePhotoResponse>?): List<Photo> {
        val items = mutableListOf<Photo>()
        input?.map {
            items.add(
                Photo(
                    id = it.id,
                    albumId = it.albumId,
                    title = it.title,
                    url = it.url,
                    thumbnailUrl = it.thumbnailUrl
                )
            )
        }
        return items
    }
}
