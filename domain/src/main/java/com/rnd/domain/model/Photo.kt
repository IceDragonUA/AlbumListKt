package com.rnd.domain.model

/**
 * @author Vladyslav Havrylenko
 * @since 09.06.2021
 */
data class Photo(
    val id: Int,
    val albumId: Int,
    val title: Int,
    val url: String,
    val thumbnailUrl: String
)