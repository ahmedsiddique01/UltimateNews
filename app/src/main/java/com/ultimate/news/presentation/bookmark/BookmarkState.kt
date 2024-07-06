package com.ultimate.news.presentation.bookmark

import com.ultimate.news.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)