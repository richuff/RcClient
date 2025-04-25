package com.richuff.rcclient.core.design.component

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.richuff.rcclient.core.design.theme.MarginSmallSpacer
import com.richuff.rcclient.core.extension.clickNoRipple
import com.richuff.rcclient.feature.main.TopLevelNavigation

/**
 * <h2>底部导航栏</h2>
 *
 * <h3>用于渲染底部的导航栏，每个小组件由一个Image和一个Text组成</h3>
 * @param destinations 需要渲染的TopLevelNavigation列表
 * @param modifier 样式的设置
 * @param currentNavigate 当前的路径目录
 * @param onNavigationDestination 切换路径的方法
 * @author richu
 *
 * Create by 2025 4.11
 */
@Composable
fun MyNavBar(
    destinations: List<TopLevelNavigation>,
    modifier: Modifier = Modifier,
    currentNavigate: String,
    onNavigationDestination: (Int) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        destinations.forEachIndexed({ index, item ->
            var selected = destinations[index].routePath == currentNavigate
            var color = if (selected)
                MaterialTheme.colorScheme.primary
            else
                MaterialTheme.colorScheme.onSurface
            Column(
                modifier = Modifier.weight(1f).clickNoRipple{
                    onNavigationDestination(index)
                },
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(if (selected) item.selectIconId else item.unSelectIconId),
                    contentDescription = stringResource(item.titleTextId),
                    modifier = Modifier.size(20.dp)
                )

                MarginSmallSpacer()

                Text(text = stringResource(item.titleTextId), color = color)
            }
        })
    }
}