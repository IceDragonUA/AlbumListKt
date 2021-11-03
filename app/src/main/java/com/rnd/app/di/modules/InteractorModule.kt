package com.rnd.app.di.modules

import com.rnd.domain.interactor.Interactor
import org.koin.dsl.module

val interactorModule = module {
    single { Interactor(repository = get()) }
}