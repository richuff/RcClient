package com.richuff.rcclient.core.design.model

import kotlinx.serialization.Serializable

@Serializable
class Sheet(
    val id: String? = null,
    val created: String? = null,
    val updated: String? = null,
    val title: String? = null,
    val icon: String? = null,
    val detail: String? = null,
    val clicksCount: Int,
    val collectsCount: Int,
    val commentsCount: Int,
    val songsCount: Int = 0,
    val userId: String? = null,
    val songs: List<Song> = emptyList<Song>()
) {
    val isSelected: Boolean
        get() = userId?.isNotBlank() == true
}

fun SHEET_EMPTY(): Sheet{
    return Sheet(
        id = "1",
        created = "2200-04-09T16:28:49Z",
        updated = "2025-04-08T12:31:06Z",
        title = "????",
        icon = "assets/list1.jpg",
        detail = "test",
        clicksCount = 19542,
        collectsCount = 24,
        commentsCount = 44,
        songsCount = 0,
        userId = "1"
    )
}