package com.rnd.domain.model

/**
 * @author Vladyslav Havrylenko
 * @since 09.06.2021
 */
data class Photo(
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)