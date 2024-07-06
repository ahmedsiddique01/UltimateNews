package com.ultimate.news.domain.usecases.news

import androidx.paging.PagingData
import com.ultimate.news.domain.model.Article
import com.ultimate.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}