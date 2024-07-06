package com.ultimate.news.domain.usecases.news

import com.ultimate.news.data.local.NewsDao
import com.ultimate.news.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }

}