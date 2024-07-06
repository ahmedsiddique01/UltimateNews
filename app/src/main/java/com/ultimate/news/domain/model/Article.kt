package com.ultimate.news.domain.model

import androidx.datastore.core.Serializer
import com.ultimate.news.domain.model.Source
import java.io.Serializable

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
):Serializable