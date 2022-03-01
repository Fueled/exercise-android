package com.fueled.technicalchallenge.di

import android.app.Application
import android.content.Context
import com.fueled.technicalchallenge.core.DispatcherProvider
import com.fueled.technicalchallenge.domain.CrmRepository
import com.fueled.technicalchallenge.domain.CrmRepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideDispatcherProvider(): DispatcherProvider = DispatcherProvider()

}
