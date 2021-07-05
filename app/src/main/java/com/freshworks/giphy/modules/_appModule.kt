package com.freshworks.giphy.modules

import com.freshworks.giphy.factory.*
import com.freshworks.giphy.repository.GiphyRepository
import com.freshworks.giphy.viewmodels.FavoriteViewModel
import com.freshworks.giphy.viewmodels.TrendingViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { TrendingViewModel(get()) }
    factory { FavoriteViewModel(get()) }
}

val repositoryModule = module {
    single { GiphyRepository(get(), get()) }
    single { FavoriteDaoFactory.create(get()) }
    single { GiphyDatabaseFactory.create(get()) }
}

val networkModule = module {
    single { GiphyApiFactory.create(get()) }
    single { RetrofitFactory.create(get(), get()) }
    single { OkHttpClientFactory.create() }
    single { MoshiFactory.create() }
}
