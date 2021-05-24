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
    // Named 어노테이션에 따라 retrofit 클라이언트 구분
    @Provides
    fun provideApiService(@Named("retrofit_1") retrofit: Retrofit) = retrofit.create(ApiService::class.java)
}