package com.richuff.rcclient.feature.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SPLASH_NAV:String = "splash"

fun NavGraphBuilder.splashScreen(toMain:()->Unit){
    composable(SPLASH_NAV) {
        SplashRoute(toMain = toMain)
    }
}