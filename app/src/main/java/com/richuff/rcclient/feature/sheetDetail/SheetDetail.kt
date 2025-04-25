package com.richuff.rcclient.feature.sheetDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.richuff.rcclient.core.design.model.Sheet
import com.richuff.rcclient.core.design.theme.MarginSmallSpacer
import com.richuff.rcclient.feature.song.component.ItemSongSheet
import com.richuff.rcclient.feature.song.component.SongItem

@Composable
fun SheetDetailRoute(
    toMain: () -> Unit = {},
    viewmodel: SheetDetailViewModel = viewModel<SheetDetailViewModel>()
) {
    val datas = viewmodel.datas.collectAsState()
    SheetDetailScreen(toMain = toMain,datas = datas.value)
}

@Composable
fun SheetDetailScreen(toMain: () -> Unit,datas:Sheet) {
    Scaffold (topBar = {

    }, modifier = Modifier.fillMaxSize()){ paddingValue->
        LazyColumn(modifier = Modifier.padding(paddingValue)) {
            itemsIndexed(datas.songs){  index,song ->
                ItemSongSheet(index = index,song = song)
            }
        }
    }
}