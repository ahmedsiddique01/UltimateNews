package com.ultimate.news.di

import android.app.Application
import androidx.room.Room
import com.ultimate.news.data.local.NewsDao
import com.ultimate.news.data.local.NewsDatabase
import com.ultimate.news.data.local.NewsTypeConvertor
import com.ultimate.news.data.manger.LocalUserMangerImpl
import com.ultimate.news.data.remote.NewsApi
import com.ultimate.news.data.repository.NewsRepositoryImpl
import com.ultimate.news.domain.manger.LocalUserManger
import com.ultimate.news.domain.repository.NewsRepository
import com.ultimate.news.domain.usecases.app_entry.AppEntryUseCases
import com.ultimate.news.domain.usecases.app_entry.ReadAppEntry
import com.ultimate.news.domain.usecases.app_entry.SaveAppEntry
import com.ultimate.news.domain.usecases.news.GetNews
import com.ultimate.news.domain.usecases.news.NewsUseCases
import com.ultimate.news.domain.usecases.news.SearchNews
import com.ultimate.news.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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


    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao:NewsDao
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi, newsDao)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }


    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}