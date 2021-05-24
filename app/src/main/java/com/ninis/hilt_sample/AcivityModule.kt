package com.ninis.hilt_sample

import com.ninis.hilt_sample.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit
import javax.inject.Named

@Module
@InstallIn(ActivityRetainedComponent::class)
class AcivityModule {
    @Provides
    fun provideApiService(@Named("retrofit_1") retrofit: Retrofit) = retrofit.create(ApiService::class.java)
}