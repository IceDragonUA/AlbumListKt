package com.rnd.data.mapper

import com.rnd.data.common.RemoteEntityToDomainMapper
import com.rnd.data.datasource.remote.model.RemoteAlbumResponse
import com.rnd.domain.model.Album

class NetworkAlbumMapper: RemoteEntityToDomainMapper<List<RemoteAlbumResponse>, List<Album>> {

    override fun map(input: List<RemoteAlbumResponse>?): List<Album> {
        val items = mutableListOf<Album>()
        input?.map {
            items.add(
                Album(
                    id = it.id,
                    userId = it.userId,
                    title = it.title
                )
            )
        }
        return items
    }
}
