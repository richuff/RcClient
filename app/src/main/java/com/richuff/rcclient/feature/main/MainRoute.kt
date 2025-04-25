package com.richuff.rcclient.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.richuff.rcclient.core.design.component.MyNavBar
import com.richuff.rcclient.feature.discovery.DISCOVER_ROUTE
import com.richuff.rcclient.feature.discovery.DisCoverRoute
import com.richuff.rcclient.feature.feed.FeedRoute
import com.richuff.rcclient.feature.me.MeRoute
import com.richuff.rcclient.feature.shortvideo.ShortVideoRoute
import kotlinx.coroutines.launch

@Composable
fun MainRoute(modifier: Modifier = Modifier, finished: () -> Unit = {}) {
    MainScreen(modifier, finished)
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, finished: () -> Unit) {
    var currentDestination by rememberSaveable {
        mutableStateOf(TopLevelNavigation.DISCOVER.routePath)
    }
    val pageState = rememberPagerState {
        4
    }
    val scope = rememberCoroutineScope()
    Column{
        HorizontalPager(
            modifier = Modifier.fillMaxWidth().weight(1f),
            userScrollEnabled = false, //不允许用户滑动切换页面
            beyondViewportPageCount = 4, //加载其他数量页面
            state = pageState
        ) { page ->
            when (page) {
                0 -> DisCoverRoute()
                1 -> FeedRoute()
                2 -> ShortVideoRoute()
                3 -> MeRoute()
            }
        }
        MyNavBar(
            TopLevelNavigation.entries,
            currentNavigate = currentDestination,
            onNavigationDestination = { index->
                currentDestination = TopLevelNavigation.entries[index].routePath
                scope.launch {
                    pageState.scrollToPage(index)
                }
            },
            modifier = Modifier
        )
    }
}
