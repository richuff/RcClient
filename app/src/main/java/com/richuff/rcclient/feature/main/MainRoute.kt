package com.richuff.rcclient.feature.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.richuff.rcclient.core.design.component.MyNavBar
import com.richuff.rcclient.feature.discovery.DISCOVER_ROUTE
import com.richuff.rcclient.feature.discovery.DisCoverRoute
import com.richuff.rcclient.feature.feed.FeedRoute
import com.richuff.rcclient.feature.me.MeRoute
import com.richuff.rcclient.feature.shortvideo.ShortVideoRoute

@Composable
fun MainRoute(modifier: Modifier = Modifier, finished: () -> Unit = {}) {
    MainScreen(modifier, finished)
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, finished: () -> Unit) {
    val pageState = rememberPagerState {
        4
    }
    HorizontalPager(
        modifier = Modifier.fillMaxWidth(),
        userScrollEnabled = false, //不允许用户滑动切换页面
        beyondViewportPageCount = 4, //加载其他数量页面
        state = pageState
    ) { page ->
        when (page) {
            0 -> DisCoverRoute()
            1 -> ShortVideoRoute()
            2 -> MeRoute()
            3 -> FeedRoute()
        }
    }
    MyNavBar(
        TopLevelNavigation.entries,
        currentNavigate = DISCOVER_ROUTE,
        onNavigationDestination = { index->

        },
        modifier = Modifier
    )
}
