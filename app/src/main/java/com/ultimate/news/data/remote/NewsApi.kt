package com.ultimate.news.data.remote

import com.ultimate.news.BuildConfig.API_KEY
import com.ultimate.news.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("sortBy") sortBy: String = "publishedAt"
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("sortBy") sortBy: String = "publishedAt"
    ): NewsResponse
}