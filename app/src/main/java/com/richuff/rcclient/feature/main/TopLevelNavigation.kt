package com.richuff.rcclient.feature.main

import com.richuff.rcclient.R
import com.richuff.rcclient.feature.discovery.DISCOVER_ROUTE
import com.richuff.rcclient.feature.feed.FEED_ROUTE
import com.richuff.rcclient.feature.me.ME_ROUTE
import com.richuff.rcclient.feature.shortvideo.SHORT_VIDEO_ROUTE

enum class TopLevelNavigation (
    val selectIconId: Int,
    val unSelectIconId:Int,
    val titleTextId: Int,
    val routePath: String,
){
    DISCOVER(
        selectIconId = R.drawable.aroha,
        unSelectIconId = R.drawable.aroha,
        titleTextId = R.string.discover,
        routePath = DISCOVER_ROUTE
    ),
    FEED(
        selectIconId = R.drawable.expect,
        unSelectIconId = R.drawable.expect,
        titleTextId = R.string.feed,
        routePath = FEED_ROUTE
    ),
    SHORT_VIDEO(
        selectIconId = R.drawable.reward,
        unSelectIconId = R.drawable.reward,
        titleTextId = R.string.short_video,
        routePath = SHORT_VIDEO_ROUTE
    ),
    ME(
        selectIconId = R.drawable.love,
        unSelectIconId = R.drawable.love,
        titleTextId = R.string.me,
        routePath = ME_ROUTE
    )
}