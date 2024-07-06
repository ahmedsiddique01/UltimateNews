package com.ultimate.news.presentation.details

import com.ultimate.news.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}