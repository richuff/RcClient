package com.richuff.rcclient.core.design.model

import com.richuff.rcclient.util.Constant
import kotlinx.serialization.Serializable



@Serializable
data class Song(
    val id:Int,
    val icon:String = "",
    val artists: String = "",
    val album: String = "",
    val lyric: String = "",
    val genre: String,
    val title:String,
    val uri:String,
    val lyricStyle: Int = Constant.VALUE0,
    val likesCount: Int,
    val clicksCount: Int,
    val commentsCount: Int,
    val userId:String

//    val created: LocalDateTime,
//    val updated: LocalDateTime,
)