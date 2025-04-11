package com.richuff.rcclient.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.richuff.rcclient.R
import com.richuff.rcclient.core.design.theme.RcClientTheme
import com.richuff.rcclient.util.SuperDateUtil
import java.time.Year

@Composable
fun SplashRoute(
    toMain: () -> Unit,
    viewmodel: SplashViewModel = viewModel()
): Unit {

    val timeLeft by viewmodel.timeLeft.collectAsStateWithLifecycle()
    val navToHome by viewmodel.navToHome.collectAsStateWithLifecycle()

    SplashScreen(
        year = SuperDateUtil.getYear(),
        modifier = Modifier.fillMaxSize(),
        timeLeft = timeLeft,
        skipAd = viewmodel::skipAd
    )
    if (navToHome) {
        LaunchedEffect(key1 = true) {
            toMain()
        }
    }
}

@Composable
fun SplashScreen(
    year: Int,
    timeLeft: Long = 0,
    skipAd: () -> Unit,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        //图片显示
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "background",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxSize()
                .padding(start = 30.dp, end = 30.dp),
        ) //contentScale = ContentScale.FillHeight)

        //版权文本
        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomCenter),
            text = String.format(stringResource(id = R.string.Copyright), year),
            style = TextStyle(color = Color.Gray, fontSize = 12.sp)
        )

        //跳过按钮
        Button(
            onClick = { skipAd() },
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.TopEnd),
            //.shadow(elevation = 1.dp, shape = RectangleShape),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0x44888888))
        ) {
            Text(text = "跳过 $timeLeft", color = Color.Black, style = TextStyle(fontSize = 16.sp))
        }
    }
}

@Preview
@Composable
fun Show() {
    RcClientTheme {
//        Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
//            SplashRoute(Modifier.padding(padding), toMain = {})
//        }
    }
}

