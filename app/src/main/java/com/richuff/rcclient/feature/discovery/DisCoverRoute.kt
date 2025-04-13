package com.richuff.rcclient.feature.discovery

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.richuff.rcclient.R
import com.richuff.rcclient.core.design.theme.midIcon

@Composable
fun DisCoverRoute() {
    DisCoverScreen()
}


@Composable
fun DisCoverScreen(
    toggleDrawer: () -> Unit = {},
    toSearch: () -> Unit = {}
) {
    Scaffold(topBar = {
        DisCoverTopAppBar(toggleDrawer = toggleDrawer, toSearch = toSearch)
    }) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValue)
        ) {
            Text("test")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisCoverTopAppBar(toggleDrawer: () -> Unit, toSearch: () -> Unit) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(
                onClick = toggleDrawer
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier.size(midIcon)
                )
            }
        },
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(38.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(50.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .clickable {
                        toSearch()
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.outline,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = stringResource(R.string.search),
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    modifier = Modifier.size(midIcon)
                )
            }
        }
    )
}

@Preview
@Composable
fun Preview() {
    DisCoverScreen()
}