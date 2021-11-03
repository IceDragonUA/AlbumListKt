package com.rnd.app.di.modules

import com.rnd.app.common.base.HeaderInterceptor
import com.rnd.app.ui.album.AlbumViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { HeaderInterceptor(androidApplication()) }
    viewModel { AlbumViewModel() }
}
