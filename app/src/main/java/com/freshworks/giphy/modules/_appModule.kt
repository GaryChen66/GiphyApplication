package com.freshworks.giphy.modules

import com.freshworks.giphy.factory.FavoriteDaoFactory
import com.freshworks.giphy.factory.GiphyDatabaseFactory
import org.koin.dsl.module

val repositoryModule = module {
    single { FavoriteDaoFactory.create(get()) }
    single { GiphyDatabaseFactory.create(get()) }
}