package com.ultimate.news.data.remote.dto

import com.ultimate.news.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)