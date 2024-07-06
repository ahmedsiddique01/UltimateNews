package com.ultimate.news.domain.usecases.news

import com.ultimate.news.data.local.NewsDao
import com.ultimate.news.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.upsert(article = article)
    }

}