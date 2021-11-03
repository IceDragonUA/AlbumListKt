package com.rnd.app.di.modules

import com.rnd.data.repository.NetworkRepositoryImpl
import com.rnd.domain.repository.NetworkRepository
import org.koin.dsl.module

/**
 * @author Vladyslav Havrylenko
 * @since 23.12.2020
 */

val repositoryModule = module {
    single<NetworkRepository> {
        NetworkRepositoryImpl(
            api = get(),
            albumMapper = get(),
            photoMapper = get(),
        )
    }
}