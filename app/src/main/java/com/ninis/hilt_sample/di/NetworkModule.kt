package com.ninis.hilt_sample.di

import com.ninis.hilt_sample.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideTypicodeApi(@TypicodeClient retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    /**
     * baseUrl 마다 client 생성을 할수 있도록 구현
     * Main, Sub... +a
     */
    @TypicodeClient
    @Provides
    fun provideTypicodeRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @GithubClient
    @Provides
    fun provideGithubRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://api.github.com")
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

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TypicodeClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GithubClient