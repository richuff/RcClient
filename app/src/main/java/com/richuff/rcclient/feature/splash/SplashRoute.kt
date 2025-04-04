package com.richuff.rcclient.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.richuff.rcclient.R
import com.richuff.rcclient.core.design.theme.RcClientTheme

@Composable
fun SplashRoute(): Unit {
    SplashScreen(Modifier.fillMaxSize());
}

@Composable
fun SplashScreen(
    modifier: Modifier
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.background),
            contentDescription = "background",
        modifier = Modifier
            .align(Alignment.TopCenter)
            .fillMaxSize(),) //contentScale = ContentScale.FillHeight)
        Text(modifier = Modifier.padding(10.dp).align(Alignment.BottomCenter),text = stringResource(id = R.string.Copyright)
        , style = TextStyle(color = Color.Gray, fontSize = 12.sp)
        )

    }
}

@Preview
@Composable
fun Show(){
    RcClientTheme {
        SplashRoute()
    }
}

