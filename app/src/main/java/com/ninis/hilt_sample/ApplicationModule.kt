package com.ninis.hilt_sample

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    /**
     * baseUrl 마다 client 생성을 할수 있도록 Named 어노테이션 사용해봄
     */
    @Provides
    @Named("retrofit_1")
    fun provideRetrofit1(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Named("Retrofit_2")
    fun provideRetrofit2(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    @Provides
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}