package com.example.news_mobile.Model

data class NewsModel(
    val status: String,
    val totalResults: String,
    val articles: List<Articles>?
)

