package com.ninis.hilt_sample.di

import com.ninis.hilt_sample.network.ApiService
import com.ninis.hilt_sample.network.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        apiService: ApiService
    ) = MainRepository(
        apiService
    )
}