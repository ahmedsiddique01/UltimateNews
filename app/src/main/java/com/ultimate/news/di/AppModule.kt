package com.ultimate.news.di

import android.app.Application
import com.ultimate.news.data.manger.LocalUserMangerImpl
import com.ultimate.news.domain.manger.LocalUserManger
import com.ultimate.news.domain.usecases.app_entry.AppEntryUseCases
import com.ultimate.news.domain.usecases.app_entry.ReadAppEntry
import com.ultimate.news.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}