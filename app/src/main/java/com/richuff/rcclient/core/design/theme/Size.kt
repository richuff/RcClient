package com.richuff.rcclient.core.design.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val marginSmall = 5.dp
val marginMid = 10.dp
val midIcon = 30.dp
val largeImage = 50.dp

@Composable
fun MarginSmallSpacer() {
    Spacer(modifier = Modifier.size(marginSmall))
}