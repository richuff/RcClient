package com.richuff.rcclient

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.richuff.rcclient.core.design.theme.RcClientTheme
import com.richuff.rcclient.feature.splash.SplashRoute
import com.richuff.rcclient.ui.MyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //允许显示到状态栏内,文字显示为白色
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT))


        setContent {
            val controller = rememberNavController()

            RcClientTheme {
                Scaffold (modifier = Modifier.fillMaxSize()){padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        MyApp(controller)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RcClientTheme {
        val controller = rememberNavController()
        Scaffold (modifier = Modifier.fillMaxSize()){padding ->
            Box(modifier = Modifier.padding(padding)) {
                MyApp(controller)
            }
        }
    }
}