package com.rnd.app.di.modules

import com.rnd.data.mapper.NetworkAlbumMapper
import com.rnd.data.mapper.NetworkPhotoMapper
import org.koin.dsl.module

val commonModule = module {
    single { NetworkAlbumMapper() }
    single { NetworkPhotoMapper() }
}