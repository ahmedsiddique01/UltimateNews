package com.ultimate.news.domain.usecases.news

import com.ultimate.news.data.local.NewsDao
import com.ultimate.news.domain.model.Article

class GetArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}